package step_definitions;

import Pages.Page_Base;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtils;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;
    static Page_Base PageBase;



    @BeforeAll
    public static void user_opens_chrome_browser()
    {
        // ***Select web driver to open browser*** //
        // Method 1 //
        //System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        // Another Method //
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

       
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        PageBase = new Page_Base(driver);

    }

    @AfterAll
    public static void user_closes_the_driver() {
        BrowserUtils.waitFor(2);
        driver.quit();
    }
}
