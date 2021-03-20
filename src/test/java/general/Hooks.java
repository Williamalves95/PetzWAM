package general;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks extends Base{
    private Base base;

    // construtor para a classe base
    public Hooks(Base base) {
        super(base.driver);
        this.base = base;
    }


    @Before
    public void setup(){
        // Onde esta o drive  browser navegador
        System.setProperty("webdriver.chrome.driver" , "drivers/chrome/88/chromedriver.exe");
         // instanciar o driver chrome
        base.driver = new ChromeDriver();

        // maximizar a tela
        base.driver.manage().window().maximize();

        // definir a espera implicita do selenium WebDriver para 1 minuto
        base.driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);


    }

    @After
    public void tearDown(){
        base.driver.quit();

    }
}


