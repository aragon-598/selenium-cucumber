package pages;

public class TablePage extends BasePage {

    private String locator = "//*[@id=\"root\"]/div/";

    public TablePage() {
        super(driver);
    }

    public void navigateToTable() {
        navigateTo("https://1v2njkypo4.csb.app/");
    }

    public String getValueFromGridTable(int row, int column) {

        return getValueFromTable(locator, row, column);
    }
    
}
