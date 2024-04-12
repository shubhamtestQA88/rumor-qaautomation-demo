package com.agroworlds.pageobjects.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
    public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
        PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//input[@type=\"email\"]")
	WebElement Email;
	
	@FindBy(xpath="//*[@id=\"select2-countrycode-container\"]")
	WebElement Country;
	
	@FindBy(xpath="/html/body/span/span/span[2]/ul/li[2]/span[2]")
	WebElement countrycode;

	@FindBy(xpath="//input[@name=\"phone\"]")
	WebElement phone;
	
	@FindBy(xpath="//button[text()='Verify']")
	WebElement verifyLogin;
	
	@FindBy(xpath="//input[@id=\"phoneFirst\"]")
	WebElement OTP;
	
	@FindBy(xpath="//button[@id=\"verify\"]")
	WebElement OTPverify;
	
	@FindBy(xpath="//a[@class=\"nav-link dropdown-toggle\"]")
	WebElement profileButton;
	
	@FindBy(xpath="//a[@class=\"log-out\"]")
	WebElement logout;
	
	public WebElement getEmail() {
		return Email;
	}

	public WebElement getCountry() {
		return Country;
	}

	public WebElement getCountrycode() {
		return countrycode;
	}
	
	public WebElement getPhone() {
		return phone;
	}

	public WebElement getVerifyLogin() {
		return verifyLogin;
	}

	public WebElement getOTP() {
		return OTP;
	}

	public WebElement getOTPverify() {
		return OTPverify;
	}
	
	public WebElement getProfileButton() {
		return profileButton;
	}

	public WebElement getLogout() {
		return logout;
	}


}
