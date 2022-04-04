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

    @When("^Busco (.+) en la lista$")
    public void findList(String state) throws InterruptedException{
        list.enterSearchCriteria(state);
    }

    @Then("^Encuentro (.+) en la lista$")
    public void findText(String city) {
        List<String> estados = list.getAllSearchResults();

        boolean txtIsThere = estados.contains(city);

        if (txtIsThere) {
            System.out.println("El texto está en la lista. PASED");
        } else {
            throw new Error("El texto no está en la lista. FAILED");
        }
    }
}
