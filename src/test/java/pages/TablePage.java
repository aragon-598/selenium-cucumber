package pages;

public class TablePage extends BasePage {

    private String locator = "//body/div[@id='root']/div[1]/table[1]";

    public TablePage() {
        super(driver);
    }

    public void navigateToTable() {
        navigateTo("https://1v2njkypo4.csb.app/");
    }

    public String getValueFromGridTable(int row, int column) {

        return getValueFromTable(locator, row, column);
    }
    
    public boolean cellStatus() {
        return elementisDisplayed(locator);
    }
}
