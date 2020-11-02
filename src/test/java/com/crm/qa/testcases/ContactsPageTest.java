package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;


public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	   
	public ContactsPageTest(){
			super();
			
	}
	
	
	@BeforeMethod (alwaysRun = true)
	public void setUp() throws InterruptedException {
		
		initialization();
		log.info("*************************ContactsPageBrowser->Starts*****************************");
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//TestUtil.runTimeInfo("error", "login successful");
		///testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1,groups="smoke")
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContctsLabel(), "contacts label is missing on the page");
	}
	
//	@Test(priority=2)
//	public void selectSingleContactsTest(){
//		contactsPage.selectContactsByName("def 456");
//	
//		
//	}
//	
//	@Test(priority=3)
//	public void selectMultipleContactsTest(){
//		contactsPage.selectContactsByName("abc 123");
//		contactsPage.selectContactsByName("ghi 789");

//	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4, dataProvider="getCRMTestData", groups="sanity")
	public void validateCreateNewContact(String firstName, String lastName, String company){
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.creatNewContact(firstName, lastName, company);
	}
	
	

	@AfterMethod (alwaysRun = true)
	public void tearDown(){
		log.info("***************************ContactsPageBrowser->Stops**********************************");
		driver.quit();
	}
	
	
	
}
