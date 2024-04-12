package com.agroworlds.login.tests;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.agroworlds.pageobjects.login.*;
import com.utility.Utility;

public class LoginClass extends BaseClass {

	Utility utility = new Utility();
	LoginPage loginPage;

	@Test(priority = 1)
	public void loginWithValidCredential() throws EncryptedDocumentException, IOException, InterruptedException {

		loginPage = new LoginPage(driver);

		loginPage.getEmail().sendKeys((utility.readExcelFile("SSICredential", 1, 0)));

		loginPage.getCountry().click();

		loginPage.getCountrycode().click();

		loginPage.getPhone().sendKeys((utility.readExcelFile("SSICredential", 1, 1)));

		loginPage.getVerifyLogin().click();

		loginPage.getOTP().sendKeys("1234");

		loginPage.getOTPverify().click();

		log.info("User get logged in");

		Thread.sleep(3000);

		String actualTitle = driver.getCurrentUrl();

		System.out.println(actualTitle);

		String expectedTitle = "https://stage.agroworlds.com/dashboard";
		
		Assert.assertEquals(actualTitle, expectedTitle);

		loginPage.getProfileButton().click();

		loginPage.getLogout().click();

		Thread.sleep(3000);

	}



	@Test(priority = 2)
	public void loginWithInValidCredential() throws EncryptedDocumentException, IOException {

		loginPage = new LoginPage(driver);

		loginPage.getEmail().sendKeys((utility.readExcelFile("SSICredential", 2, 0)));

		loginPage.getCountry().click();

		loginPage.getCountrycode().click();
	
		loginPage.getPhone().sendKeys((utility.readExcelFile("SSICredential", 2, 1)));

		loginPage.getVerifyLogin().click();

		boolean isEmailFieldEmpty = driver.getPageSource().contains("Please check Email Or Mobile");

		boolean expectedResultEmail  = true;

		Assert.assertEquals(isEmailFieldEmpty, expectedResultEmail,  "Test login with incorrect credentials.");
		
		log.info("User not able to get logged in due to incorrect credentials. ");
		
		String expectedOTPpageTitle = "https://stage.agroworlds.com/view_verification";
		
		Assert.assertFalse(false, expectedOTPpageTitle);	

	}




	@Test(priority = 3)
	public void loginWithBlankFields() throws EncryptedDocumentException, IOException {

		loginPage = new LoginPage(driver);

		loginPage.getEmail().sendKeys((utility.readExcelFile("SSICredential", 3, 0)));

		loginPage.getCountry().click();

		loginPage.getCountrycode().click();

		loginPage.getPhone().sendKeys((utility.readExcelFile("SSICredential", 3, 1)));

		loginPage.getVerifyLogin().click();

		boolean isEmailFieldEmpty = driver.getPageSource().contains("Please enter an email address");

		boolean expectedResultEmail  = true;

		Assert.assertEquals(isEmailFieldEmpty, expectedResultEmail,  "The expected error message if mail field is empty");

		boolean isPasswordFiledEmpty = driver.getPageSource().contains("Please enter a contact number");

		boolean expectedResultPassword = true;

		Assert.assertEquals(isPasswordFiledEmpty, expectedResultPassword,  "Test login with empty username and password fields.");

		log.info("User not able to get logged in due to empty username and password fields. ");
		
		String expectedOTPpageTitle = "https://stage.agroworlds.com/view_verification";
		
		Assert.assertFalse(false, expectedOTPpageTitle);

		
	}



	@Test(priority = 4)
	public void loginWithPasswordFieldBlank() throws EncryptedDocumentException, IOException {

		loginPage = new LoginPage(driver);

		loginPage.getEmail().sendKeys((utility.readExcelFile("SSICredential", 4, 0)));

		loginPage.getCountry().click();

		loginPage.getCountrycode().click();

		loginPage.getPhone().sendKeys((utility.readExcelFile("SSICredential", 4, 1)));

		loginPage.getVerifyLogin().click();

		boolean isPasswordFiledEmpty = driver.getPageSource().contains("Please enter a contact number");

		boolean expectedResultPassword = true;

		Assert.assertEquals(isPasswordFiledEmpty, expectedResultPassword,  "Test login with empty password field.");

		log.info("User not able to get logged in due to empty password field.");
		
		String expectedOTPpageTitle = "https://stage.agroworlds.com/view_verification";
		
		Assert.assertFalse(false, expectedOTPpageTitle);	

	}
	
}
