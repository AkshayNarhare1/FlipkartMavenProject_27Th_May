package Utils;


import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

public class SeleniumUtils {

    static WebDriver driver;

    public static WebElement explicitWait(WebDriver driver, int time, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement explicitWait(WebDriver driver, int time, By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void explicitWaitForInvisibility(WebDriver driver, int time, By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public static void clickByJSE(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void hoverOnElement(WebDriver driver, WebElement element){
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
    }

    public static void pressKeyboardKey(WebDriver driver, String key) {
        Actions actions = new Actions(driver);
        if(key.equalsIgnoreCase("ENTER"))
            actions.sendKeys(Keys.ENTER).perform();
        else if(key.equalsIgnoreCase("TAB"))
            actions.sendKeys(Keys.TAB).perform();
        else if(key.equalsIgnoreCase("ESCAPE"))
            actions.sendKeys(Keys.ESCAPE).perform();
        else if(key.equalsIgnoreCase("DOWN"))
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        else if(key.equalsIgnoreCase("UP"))
            actions.sendKeys(Keys.ARROW_UP).perform();
        else if(key.equalsIgnoreCase("LEFT"))
            actions.sendKeys(Keys.ARROW_LEFT).perform();
        else if(key.equalsIgnoreCase("RIGHT"))
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
    }


    public static String getDataFromDataSheet(String filePath, String sheetName, int rowNum, int cellNum){
        try {
            FileInputStream file = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            return workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void setDriver(WebDriver driver){
        SeleniumUtils.driver = driver;
    }


    @Attachment(type = "image/png")
    public static ByteArrayInputStream takeScreenshotAndAttach(){
        return new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
    }

    @Attachment(value = "msg", type = "text/plain")
    public static String attachMessage(String msg){
        Allure.addAttachment("msg", msg);
        return msg;
    }



}
