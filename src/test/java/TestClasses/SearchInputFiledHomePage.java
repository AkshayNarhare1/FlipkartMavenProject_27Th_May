package TestClasses;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

import BaseClasses.Base1;
import POMClasses.HomePage;
import POMClasses.LoginPage;
import POMClasses.ProfilePage;
import Utils.SeleniumUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class SearchInputFiledHomePage extends Base1 {
	
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
    public void beforeMethod() {
  	  
    	System.out.println("Before Method");
        //SeleniumUtils.setDriver(driver);
        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        pp = new ProfilePage(driver);
  	  
    }
    
  @Test
  public void testCase1() {
	  
	  Assert.assertTrue(true);
	  System.out.println("testCase1 Pass");
  }
  
  @Test
  public void testCase2() {
	  
	  Assert.assertTrue(true);
	  System.out.println("testCase2 Pass");
  }
  
  @Test
  public void testCase3() {
	  
	  Assert.assertTrue(true);
	  System.out.println("testCase3 Pass");
  }
 

  @AfterMethod
  public void afterMethod() {
  }

 

  @AfterClass
  public void afterClass() {
  }

}
