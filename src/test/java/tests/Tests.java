package tests;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tests extends SamplePoSTest {

    @Test
    public void openSamplePoS() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Scroll and Select QA 13 Environment
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(2)"));

        driver.findElement(By.xpath("//android.widget.TextView[@text='QA 13 (EU)']")).click();

        //Click Register Button
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.mypinpad.goodfellow.samplepos:id/registration"))).click();

        try {

            //Setup Permissions

            //Continue to accept or decline permissions
            wait.until(ExpectedConditions.elementToBeClickable(By.id("com.mypinpad.openmpos.terminal.insecure:id/request_permissions__btn_continue"))).click();

            //Allow permissions for Storage
            wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_button"))).click();

            //Allow permissions for Location
            wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"))).click();

            //Allow permissions for Microphone
            wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"))).click();


            //Allow permissions for Microphone
            wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"))).click();

        }catch (Exception error){
            System.out.println(error.getCause());
            System.out.println(error.getMessage());
            System.out.println("Error has occurred on application");
        }

        //Registration Completed
        Thread.sleep(24000);
        driver.navigate().back();

        //Payment Gateway Setup
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.mypinpad.goodfellow.samplepos:id/payment_gateway"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.mypinpad.goodfellow.samplepos:id/payment_gateway__submit"))).click();

        //Start Transaction

        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.mypinpad.goodfellow.samplepos:id/transaction"))).click();

        System.out.println("Registration Completed....");

    }

}




//WebElement registerApplication = driver.findElement(By.id("com.mypinpad.goodfellow.samplepos:id/registration"));
//WebElement requiredPermissionsContinue = driver.findElement(By.id("com.mypinpad.openmpos.terminal.insecure:id/request_permissions__btn_continue"));
//WebElement requiredPermissionsStorage = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
//WebElement requiredPermissionsLocation = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
//WebElement requiredPermissionsMicrophone = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
//WebElement requiredPermissionsCamera = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
//WebElement setPaymentGateway = driver.findElement(By.id("com.mypinpad.goodfellow.samplepos:id/payment_gateway"));
//WebElement submitPaymentGateway = driver.findElement(By.id("com.mypinpad.goodfellow.samplepos:id/payment_gateway__submit"));
//WebElement startTransaction = driver.findElement(By.id("com.mypinpad.goodfellow.samplepos:id/transaction"));
