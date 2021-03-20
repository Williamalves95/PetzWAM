package pages;

import general.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends Base {

    // 1- Mapeamento de Elementos
    @FindBy(id = "search")
    private WebElement txtInputSearch;

    @FindBy(css = "button.button-search")
    private  WebElement btnSearch;

    // 2 - Construtor super classe especial

    public Home(WebDriver driver) {
        super(driver);
    }


    // 3 - Ações dos Elementos

    public void  search(String product){
        txtInputSearch.click(); //clicar na caixa de pesquisa
        txtInputSearch.clear(); // limpar o conteudo na caixa de texto
        txtInputSearch.sendKeys(product); // escreve na caixa de texto

    }
    // Feature --Steps --searchWith

    public void searchWithMagnifierButton(String product) {
       search(product);
        btnSearch.click(); // clicar no botao da lupa
    }

    public void searchWithEnter(String product){
        search(product);
        txtInputSearch.sendKeys(Keys.ENTER);


    }
}
