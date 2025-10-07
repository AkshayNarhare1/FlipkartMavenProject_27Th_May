package POMClasses;

import BaseClasses.Base1;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends HomePage{

    final WebDriver driver;

    @FindBy(xpath = "//input[@class='r4vIwl BV+Dqf']")
    private WebElement mobileInputField;

    @FindBy(xpath = "//button[text()='Request OTP']")
    private WebElement requestOTPButton;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // enter mobile number in mobile number input field
    @Step()
    public void enterMobileNumber() {
        Allure.step("Enter Mobile Number");
        mobileInputField.sendKeys(Base1.getPropertyValue("mobileNumber"));
    }

    // click on request OTP button
    @Step
    public void clickOnRequestOTPButton() {
        Allure.step("Click on request OTP button");
        requestOTPButton.click();
    }




}
