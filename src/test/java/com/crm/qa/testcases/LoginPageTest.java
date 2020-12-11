 package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;



public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super();
		
	}
	
	@BeforeMethod (alwaysRun = true)
	public void setUp() {
		initialization ();
		log.info("*************************LoginPageBrowser->Starts******************************");
	    loginPage = new LoginPage();
		
	}
	
	@Test (priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test (priority=2,groups={"smoke","sanity"})
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod (alwaysRun = true)
	public void tearDown() {
		log.info("***************************LoginPageBrowser->Stops************************************");
		driver.quit();
	}
}
 