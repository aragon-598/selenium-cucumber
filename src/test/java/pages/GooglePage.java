package pages;

public class GooglePage extends BasePage {

    private String searchButton="//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[2]/div[5]/center[1]/input[1]";
    private String searchInput="//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]";
    private String resultado="";

    public GooglePage() {
        super(driver);
    }

    public void navigateToGoogle() {
        navigateTo("https://www.google.com/");
    }
    
    public void clickGoogleSearch() {
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria) {
        write(searchInput, criteria);
    }

    public String  resultado() {
        return txtFromElement(resultado);
    }
}
