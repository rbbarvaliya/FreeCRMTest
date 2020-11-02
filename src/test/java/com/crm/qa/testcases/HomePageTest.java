package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	//test cases should be separated- independent with each other
	//before each test case - launch the browser and login
	//@test- execute cases
	//after each test case - close browser
	
	@BeforeMethod (alwaysRun = true )
	public void setUp() {
		log.info("*************************HomePageBrowser->Starts*****************************");
		initialization ();
	    loginPage = new LoginPage();
	    contactsPage = new ContactsPage();
	    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTititle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title not matched");
	}
	
	@Test(priority=2,groups="smoke")
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3,groups="sanity")
	public void verifycontactsLinkTest() {
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod (alwaysRun = true)
	public void tearDown() {
		log.info("***************************HomePageBrowser->Stops**********************************");
		driver.quit();
	}
	
	
	
	
}

