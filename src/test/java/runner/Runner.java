package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    publish = true,
    features = "src/test/resources/features",
    glue = "steps",
    tags = "@Test"
)
public class Runner {

    @AfterClass
    public static void close() {
        BasePage.closeBrowser();
    }

}
