package ListenersClasses;


import Utils.SeleniumUtils;
import io.qameta.allure.Allure;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;




public class listenerClass implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        SeleniumUtils.attachMessage("test started: " + result.getName());
        Allure.addAttachment("attach screenshot", "image/png", SeleniumUtils.takeScreenshotAndAttach(), ".png" );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        SeleniumUtils.attachMessage("Test pass" + result.getName());
        Allure.addAttachment("attach screenshot", "image/png", SeleniumUtils.takeScreenshotAndAttach(), ".png" );
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        SeleniumUtils.attachMessage("test Fail: " + result.getName());
        Allure.addAttachment("attach screenshot", "image/png", SeleniumUtils.takeScreenshotAndAttach(), ".png" );
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        SeleniumUtils.attachMessage("test Skipped: " + result.getName());
        Allure.addAttachment("attach screenshot", "image/png", SeleniumUtils.takeScreenshotAndAttach(), ".png" );
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

}
