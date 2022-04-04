package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class ListPage extends BasePage{
    private String searchField = "//body/form[1]/input[1]";
    private String searchResults = "name";

    public ListPage() {
        super(driver);
    }

    public void navigateToListPage() {
        navigateTo("https://andreidbr.github.io/JS30/06AjaxTypeAhead/index.html");
    }

    public void enterSearchCriteria(String state) throws InterruptedException {
        Thread.sleep(600);
        write(searchField, state);
    }

    public List<String> getAllSearchResults(){

        List<WebElement> lista = allElements(searchResults);
        List<String> stringFromList = new ArrayList<String>();

        for (WebElement e : lista) {
            stringFromList.add(e.getText());
        }

        return stringFromList;
    }
}
