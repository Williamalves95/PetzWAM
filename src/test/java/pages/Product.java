package pages;

import general.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.security.mscapi.CPublicKey;

public class Product extends Base {

    @FindBy(css = "div.col-md-7.prod-info:nth-child(6) > h1:nth-child(1)")
    private WebElement productTitle;

    @FindBy (css = "div.price-current")
    private WebElement PriceCurrent;

    public Product(WebDriver driver) {
        super(driver);
    }
    // Ler o Titulo da guia
       public String readTitleTab(){
        return driver.getTitle();
       }

        // Ler o nome do produto
    public String String readProductTitle(){
        return productTitle.getText();
    }

       // Ler o preço atual
    public String readPriceCurrent(){
        return PriceCurrent.getText();
    }
}

