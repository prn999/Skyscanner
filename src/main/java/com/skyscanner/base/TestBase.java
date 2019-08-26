package com.skyscanner.base;

import com.skyscanner.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
  public static WebDriver driver;
  public static Properties prop;

  public TestBase() {
    try {
      prop = new Properties();
      FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
        + "\\src\\main\\java\\com\\skyscanner\\config\\config.properties");
      prop.load(fis);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void initialization() throws InterruptedException {
    String browserName = prop.getProperty("browser");
    if (browserName.equals("chrome")) {
      System.setProperty("webdriver.chrome.driver", "C:\\Users\\JayDK\\Drivers\\chromedriver.exe");
      driver = new ChromeDriver();
    } else if (browserName.equals("firefox")) {
      /******* Yet to initialise ******/
    }

    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_IMPLICIT_WAIT, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

    driver.get(prop.getProperty("url"));
  }
}
