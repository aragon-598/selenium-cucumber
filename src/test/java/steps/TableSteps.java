package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.TablePage;

public class TableSteps {
    
    TablePage table = new TablePage();

    @Given("^Navego a la tabla$")
    public void navigatoToWebPage() {
        table.navigateToTable();
    }

    @Then("^Retorno el valor deseado$")
    public void returnValueFromTable() {
        String value = table.getValueFromGridTable(8, 3);

        System.out.println(value);
    }

    @Then("^Valido la ceda$")
    public void theTableExists() {
        boolean existe = table.cellStatus();

        Assert.assertFalse("No se cumplion la condicion",existe);
    }
}
