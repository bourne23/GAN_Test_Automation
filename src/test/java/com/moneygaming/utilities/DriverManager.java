package com.moneygaming.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private DriverManager() {

    }

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    private static final Logger logger = LogManager.getLogger(DriverManager.class);

    public static WebDriver get() {
        if (driverPool.get() == null) {

//  Pass the driver from the terminal. If not, then use properties file
            String browser = System.getProperty("browser") != null ? browser = System.getProperty("browser") : ConfigReader.getProperty("browser");

            logger.info("Instantiating driver for >> " + browser);
            try {
                switch (browser) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        break;
                    case "chrome-headless":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                        break;
                    case "edge":
                        if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                            throw new WebDriverException("Your OS doesn't support Edge");
                        WebDriverManager.edgedriver().setup();
                        driverPool.set(new EdgeDriver());
                        break;
                    default:
                }
            } catch (WebDriverException e) {
                logger.info("Exception occurred while instantiating " + browser + "  driver : " + e);
            }
        }
        return driverPool.get();

    }

    public static void closeDriver() {
        driverPool.get().quit();
        driverPool.remove();
    }
}