package steps;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ListPage;

public class ListSteps {
    ListPage list = new ListPage();

    @Given("^Navego a la webpage$")
    public void toListPage() {
        list.navigateToListPage();
    }

    @When("^Busco la lista$")
    public void findList() throws InterruptedException{
        list.enterSearchCriteria();
    }

    @Then("^Encuentro el texto en la linea$")
    public void findText() {
        List<String> estados = list.getAllSearchResults();

        boolean txtIsThere = estados.contains("Seattle, Washington");

        if (txtIsThere) {
            System.out.println("El texto está en la lista. PASED");
        } else {
            throw new Error("El texto no está en la lista. FAILED");
        }
    }
}
