package com.agroworlds.login.tests;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver createDriver(String browserType) {
        WebDriver driver;

        switch (browserType.toLowerCase()) {
            case "firefox":
            
                driver = new FirefoxDriver();
                break;
            case "edge":
               
                driver = new EdgeDriver();
                break;
            case "chrome":
            default:
               
                driver = new ChromeDriver();
                break;
                
        }

        return driver;
    }
}
