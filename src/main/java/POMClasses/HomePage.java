package POMClasses;

import Utils.SeleniumUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends SeleniumUtils {

    WebDriver driver;
    @FindBy(xpath = "//a[@title='Login']")
    private WebElement loginButton;

    By loggedInUserName = By.xpath("//a[@title='Akshay ']");

    @FindBy(xpath = "//*[text()='My Profile']")
    private WebElement myProfileButton;

    By searchBox = By.xpath("//*[@class='Pke_EE']");
    By searchedFirstProduct = By.xpath("//*[@class='tUxRFH']");


    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // click on login button on home page
    @Step
    public void clickLoginButton(){
        Allure.step("Click on login button");
        explicitWait(driver, 5, loginButton).click();
        // loginButton.click();
    }

    // check user is logged in or not
    @Step
    public boolean checkUserLoggedIn(){
        Allure.step("Check user is logged in or not");
        WebElement element = explicitWait(driver, 20, loggedInUserName);
        if(element.getText().equals("Akshay")){
            return true;
        }else{
            return false;
        }
    }

    // hover on profile name
    @Step
    public void hoverOnProfileName(){
        Allure.step("Hover on profile name");
        hoverOnElement(driver, driver.findElement(loggedInUserName));
    }

    // click on my profile button
    @Step
    public void clickOnMyProfileButton(){
        Allure.step("Click on my profile button");
        clickByJSE(driver, myProfileButton);
        //  myProfileButton.click();
    }

    @Step
    public boolean searchProduct(String productName) {
        Allure.step("Search for a product: " + productName);
        explicitWait(driver, 5, searchBox).sendKeys(productName);
        pressKeyboardKey(driver, "ENTER");
        try{
            explicitWait(driver, 5, searchedFirstProduct);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Step
    public void hoverOnProfileName1(){
        Allure.step("Hover on profile name");
        hoverOnElement(driver, driver.findElement(loggedInUserName));
    }


}
