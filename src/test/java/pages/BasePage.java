package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;

    static{
        System.setProperty("webdriver.chrome.driver", "/home/aragon/pasantia/selenium-curso/chromedriver/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
}
