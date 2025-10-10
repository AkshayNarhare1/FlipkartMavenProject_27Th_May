package TestClasses;

import BaseClasses.Base1;
import POMClasses.HomePage;
import POMClasses.LoginPage;
import POMClasses.ProfilePage;
import Utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;


public class LoginTest extends Base1 {

    HomePage hp;
    LoginPage lp;
    ProfilePage pp;
    WebDriver driver;
    SoftAssert softAssert;

    

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browser) throws IOException {
        loadConfigProperties();
       // driver = launchBrowser(getPropertyValue("browser"));
        driver = launchBrowser(browser);
        SeleniumUtils.setDriver(driver);
        driver.get(getPropertyValue("url"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("Before Class");
        softAssert = new SoftAssert();
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
        //SeleniumUtils.setDriver(driver);
        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        pp = new ProfilePage(driver);
    }

    //Test case 1
    @Test(priority = 1)
    public void VerifyUserCanLogin() {
        hp.clickLoginButton();
        lp.enterMobileNumber();
        lp.clickOnRequestOTPButton();
        softAssert.assertTrue(hp.checkUserLoggedIn());
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void VerifyUserCanLoginWithCorrectCredentials() {
        hp.clickLoginButton();
        lp.enterMobileNumber();
        lp.clickOnRequestOTPButton();
        softAssert.assertTrue(hp.checkUserLoggedIn());
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void VerifyUserCanLoginWithCorrectCredentials1() {
        hp.clickLoginButton();
        lp.enterMobileNumber();
        lp.clickOnRequestOTPButton();
        softAssert.assertTrue(hp.checkUserLoggedIn());
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
        driver.quit();
    }



}
