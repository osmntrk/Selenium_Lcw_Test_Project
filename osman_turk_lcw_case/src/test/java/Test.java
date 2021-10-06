import com.osman_turk_lcw_case.Log;
import com.osman_turk_lcw_case.pages.*;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
public class Test extends BaseTest{
    BasePage basePage;
    BasketPage basketPage;
    HomePage homePage;
    LoginPage loginPage;
    ProductDetailPage productPage;
    FindingPage findingPage;
    Log log = new Log();
    float price;

    @org.junit.jupiter.api.Test
    @Order(1)
    public void basePageRun(){
        this.basePage = new BasePage(webDriver);
        this.basePage.openWebsite();
        String URL = webDriver.getCurrentUrl();
        Assert.assertTrue(basePage.checkUrl("https://www.lcwaikiki.com/tr-TR/TR") );
        log.info("BasePage passed");
    }
    @org.junit.jupiter.api.Test
    @Order(2)
    public void homePageRun(){
        this.homePage = new HomePage(webDriver);
        this.homePage.runLoginButton();
        log.info("HomePage passed");
    }
    @org.junit.jupiter.api.Test
    @Order(3)
    public void loginPageRun(){
        this.loginPage = new LoginPage(webDriver);
        this.loginPage.LoginProcess();
        Assert.assertTrue(loginPage.checkLogin());
        log.info("LoginPage passed");
    }


    @org.junit.jupiter.api.Test
    @Order(4)
    public void searchPageRun(){
        this.findingPage = new FindingPage(webDriver);
        this.findingPage.finding();
        log.info("SearchPage passed");
    }
    @org.junit.jupiter.api.Test
    @Order(5)
    public void productPageRun(){
        this.productPage = new ProductDetailPage(webDriver);
        this.productPage.run();
        this.price = this.productPage.price;
        log.info("ProductPage passed");
    }
    @org.junit.jupiter.api.Test
    @Order(6)
    public void basketPageRun(){
        this.basketPage = new BasketPage(this.webDriver);
        this.basketPage.compare(this.price);
        Assert.assertTrue(basketPage.priceControl());
        this.basketPage.incrementCount();
        Assert.assertTrue(basketPage.incrementEquals2());
        this.basketPage.emptyBasket();
        Assert.assertTrue(basketPage.basketIsEmpty());
        log.info("BasketPage passed");
    }
}
