package com.saucelabs.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class GameTest
{
    private SelendroidDriver driver;

    @Before
    public void setUp() throws Exception {
        // set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "../../../apps");
        File app = new File(appDir, "com.fingersoft.hillclimb-v1.22.0-Android-2.3.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.fingersoft.hillclimb");
        capabilities.setCapability("appActivity", "com.fingersoft.game.MainActivity");
        driver = new SelendroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void playGame() throws IOException, InterruptedException, Exception{
      Thread.sleep(10000);
      System.out.println(driver.getOrientation().value());
      System.out.println(driver.manage().window().getSize());

      //Click next
      takeScreenShot("1");
      driver.tap(1, 1005, 535, 1);
      Thread.sleep(3000);

      //Click next
      takeScreenShot("2");
      driver.tap(1, 1005, 535, 1);
      Thread.sleep(3000);

      //Click start
      takeScreenShot("3");
      driver.tap(1, 1019, 530, 1);
      Thread.sleep(3000);

      //Click and hold gas for 10 seconds
      takeScreenShot("4");
      tapAtCoordinate(1030, 621, 15000);
      takeScreenShot("5");
    }

  public void tapAtCoordinate(int x, int y, int secs) throws Exception {
    TouchActions actions = new TouchActions(driver);
    actions.down(x, y).perform();
    Thread.sleep(secs);
    actions.up(x, y).perform();
  }


  public void takeScreenShot(String name)throws IOException{
    File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(temp, new File("C:\\my\\picture\\" + name + ".png"));
  }

}
