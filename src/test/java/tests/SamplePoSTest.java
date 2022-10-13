package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import java.net.URL;

public class SamplePoSTest {

    static AppiumDriver driver;

    @BeforeTest
    public static void setUp() {

        try {

            DesiredCapabilities cap = new DesiredCapabilities();

            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy A20e");
            cap.setCapability(MobileCapabilityType.UDID, "RZ8N71C998Z");
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");

            cap.setCapability("appPackage", "com.mypinpad.goodfellow.samplepos");
            cap.setCapability("appActivity", "com.mypinpad.goodfellow.samplepos.ConfigActivity");

            URL url = new URL("http://localhost:4723/wd/hub");

            driver = new AppiumDriver(url, cap);

            System.out.println("Application Started....");

        }catch(Exception exp){
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }

    }

}
