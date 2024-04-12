package com.agroworlds.login.tests;

import java.io.File;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



public class BaseClass {

	public Logger log = LogManager.getLogger(BaseClass.class);

	public static WebDriver driver;
	public static WebDriverWait wait;

	@Parameters("browserType")
	@BeforeClass
	public void setUp(String browserType) {

		driver = WebDriverFactory.createDriver(browserType);

		driver.get("https://stage.agroworlds.com/login/user");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			
	}

	
	
	public static String screenShot(WebDriver driver,String filename) {
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\ScreenShot\\"+filename+"_"+dateName+".png";
		File finalDestination= new File(destination);
		try 
		{
			FileUtils.copyFile(source, finalDestination);
		} 
		catch (Exception e)
		{
			e.getMessage();
		}
		return destination;
	}

	
	
	@AfterTest
	public void tearDown() {

		driver.quit();
	}



	
}





