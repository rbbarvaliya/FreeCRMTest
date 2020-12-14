package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.TestBase;


public class LoginPage extends TestBase{
	
	//Page factory - OR:
	@FindBy(name="email")
	@CacheLookup
	WebElement username;
	
	@FindBy (name= "password")
	@CacheLookup
	WebElement 	password;
	
	@FindBy (xpath="//div[@class='ui fluid large blue submit button']")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy (xpath= "//a[contains(text(),'Sign Up')]")
	@CacheLookup
	WebElement signUpBtn;

	//Initializing page Object:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	//Action
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
		
	}
}
