import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {
    WebDriver webDriver;
    public BaseTest(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/Casper/Documents/selenium dependincies/drivers");

//Initiating your chromedriver
        this.webDriver = new ChromeDriver();

//Applied wait time
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//maximize window
        webDriver.manage().window().maximize();
    }

}
