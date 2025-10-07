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


public class AddNewAddress extends Base1 {

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
       // SeleniumUtils.setDriver(driver);
        softAssert = new SoftAssert();
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
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
        Assert.assertTrue(true);
    }

    //Test case 2
    @Test(priority = 2)
    public void verifyUserCanAddNewAddress() throws InterruptedException {
        hp.hoverOnProfileName();
        hp.clickOnMyProfileButton();
        pp = new ProfilePage(driver);
        pp.clickOnManageAddress();
        pp.clickOnAddNewAddress();
        int alreadyExitingAddressCount = pp.getNumberOfAlreadyExistingAddresses();
        System.out.println("Old address Count: "+ alreadyExitingAddressCount);
        pp.enterAddressDetails();
        Thread.sleep(1000);
        int newAddressCount = pp.getNumberOfAlreadyExistingAddresses();
        System.out.println("New address Count: "+ newAddressCount);
        softAssert.assertEquals(newAddressCount, alreadyExitingAddressCount + 1);
        softAssert.assertTrue(newAddressCount == alreadyExitingAddressCount + 1);
        softAssert.assertAll();
        Assert.assertTrue(true);
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
