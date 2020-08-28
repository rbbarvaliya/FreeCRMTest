package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.TestBase;


public class LoginPage extends TestBase{
	
	//Page factory - OR:
	@FindBy(name="email")
	WebElement username;
	
	@FindBy (name= "password")
	WebElement 	password;
	
	@FindBy (xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy (xpath= "//a[contains(text(),'Sign Up')]")
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
