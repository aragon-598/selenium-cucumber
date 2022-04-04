package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static{
        System.setProperty("webdriver.chrome.driver", "/home/aragon/pasantia/selenium-curso/chromedriver/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); /**Si no encuestra el elemento en ese tiempo, la ejecución termina */
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); /**Hace una espera entre cada acción */
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        Find(locator).click();
    }

    public void write(String locator, String txtToWrite) {
        Find(locator).clear();
        Find(locator).sendKeys(txtToWrite);
    }

    public void selectFromDropDownByValue(String locator,String valueSelect) {
        Select dropdown = new Select(Find(locator));

        dropdown.selectByValue(valueSelect);
    }

    public void selectFromDropDownByIndex(String locator,Integer index) {
        Select dropdown = new Select(Find(locator));

        dropdown.selectByIndex (index);
    }

    public void selectFromDropDownByText(String locator,String valueSelect) {
        Select dropdown = new Select(Find(locator));

        dropdown.selectByVisibleText(valueSelect);
    }

    public void hoverOverElement(String locator) {
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator) {
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator) {
        action.contextClick(Find(locator));
    }

    public String getValueFromTable(String locator, int row,int column) {

        String celda = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        return Find(celda).getText();
    }

    public void switchToIFrame(int iFrameIndex) {
        driver.switchTo().frame(iFrameIndex);
    }

    public void swithToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String txtFromElement(String locator) {
        return Find(locator).getText();
    }

    public boolean elementisDisplayed(String locator) {
        return Find(locator).isDisplayed();
    }

    //https://andreidbr.github.io/JS30/06AjaxTypeAhead/index.html
    public List<WebElement> allElements(String locator) {
        return driver.findElements(By.className(locator));
    }
}
