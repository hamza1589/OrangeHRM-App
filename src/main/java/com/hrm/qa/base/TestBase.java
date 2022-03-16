package com.hrm.qa.base;

import com.hrm.qa.util.TestUtil;
import com.hrm.qa.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\hamza\\OrangeHRM\\src\\main\\java\\com\\hrm\\qa\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C://Users//hamza//Downloads//Selenium-standalone//chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "C://Users//hamza//Downloads//geckodriver-v0.30.0-win64//geckodriver.exe");

        }
        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
}


