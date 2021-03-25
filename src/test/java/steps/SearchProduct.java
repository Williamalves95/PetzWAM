package steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import general.Base;
import org.openqa.selenium.WebDriver;
import pages.Home;
import pages.List;
import pages.Product;

import static org.junit.Assert.assertEquals;

public class SearchProduct extends Base {
    private Base base;
    private Home home;
    private List list;
    private Product productClass;

    public SearchProduct(WebDriver driver, Base base) {
        super(driver);
        this.base = base;
    }

    @Given("^I access Petz homepage$")
    public void iAccessPetzHomepage(){
        base.driver.get("https://www.petz.com.br");
    }

    @When("^I search \"([^\"]*)\"$")
    public void iSearch(String product){
        home.searchWithEnter(product);

    }

    @Then("^I see a list of product \"([^\"]*)\"$")
    public void iSeeAListOfProduct(String product){
        // validar o nome da guia
        assertEquals (product + " - Produtos pet em promoção | Petz", list.readTitleTab());

        // validar o texto no Resultado Pars
         assertEquals( "Resultado para \"" + product + "\"", list.readResultBy());

    }

    @And("^I click at product \"([^\"]*)\"$")
    public void iClickAtProduct(String product){
        list.clickAtDesireProduct(product);

    }

    @Then("^show the title \"([^\"]*)\" and price \"([^\"]*)\"$")
    public void showTheTitleAndPrice(String product, String price){
        // validar o nome da guia
        assertEquals("", productClass.readProductTitle());

        // validar o nome do produto
        assertEquals(product, productClass.readProductTitle());

        // validar o preço atual
         assertEquals(price, productClass.readPriceCurrent());

        // Write code here that turns the phrase above into concrete actions

    }
}
