package POMClasses;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProfilePage extends HomePage{



    WebDriver driver;

    @FindBy(xpath = "//div[text()='Manage Addresses']")
    private WebElement manageAddressButton;

    @FindBy(xpath = "//div[@class='g8S8Av']")
    private WebElement addNewAddressButton;

    @FindBy(xpath = "//div[@class='GiZlJw']")
    private List<WebElement> exstingAddresses;


    public ProfilePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    // click on manage address button
    @Step
    public void clickOnManageAddress(){
        Allure.step("Click on manage address button");
        manageAddressButton.click();
    }

    // click on add new address button
    @Step
    public void clickOnAddNewAddress(){
        Allure.step("Click on add new address button");
        addNewAddressButton.click();
    }

    // get number of already existing addresses
    @Step
    public int getNumberOfAlreadyExistingAddresses(){
        Allure.step("Get number of already existing addresses");
        return exstingAddresses.size();
    }

    // enter address details and save the address
    @Step
    public void enterAddressDetails(){
        Allure.step("Enter address details and save the address");
        List<String> addressInfoList = new ArrayList<>();
        addressInfoList.add("Prathvi");
        addressInfoList.add("8767879644");
        addressInfoList.add("413512");
        addressInfoList.add("Latur");
        addressInfoList.add("Shivaji chowk, Latur");

        for(int i =1; i<=addressInfoList.size()-1; i++){
            WebElement element = driver.findElement(By.xpath("(//input[@class='v2VFa- z2D4XG'])["+i+"]"));
            element.sendKeys(addressInfoList.get(i-1));
        }
        driver.findElement(By.xpath("//textarea[@class='g-nBNP v2VFa- _9-gNKZ']")).sendKeys(addressInfoList.get(addressInfoList.size()-1));
        clickByJSE(driver, driver.findElement(By.xpath("//input[@id='HOME']")));
        driver.findElement(By.xpath("//button[text()='Save']")).click();
    }

}
