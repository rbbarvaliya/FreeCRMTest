package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath= "//span[@class='user-display']")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactslink;
	
	@FindBy(xpath="//div[@id='main-nav']//a[5]")
	@CacheLookup
	WebElement dealslink;
	
	@FindBy(xpath="//body//a[6]")
	@CacheLookup
	WebElement taskslink;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	@CacheLookup
	WebElement newContactLink;
	
	//Initialization 
	 	public HomePage () {
	 		PageFactory.initElements(driver, this);
	 	}
	 	
	 	public String verifyHomePageTititle() {
	 		return driver.getTitle();
	 	}
	 	
	 	public boolean verifyCorrectUserName() {
	 		return userNameLabel.isDisplayed();
	 	}
	 	
	 	public ContactsPage clickOnContactsLink() {
	 		contactslink.click();
	 		return new ContactsPage();
	 	}
	 	
	 	public DealsPage clickOnDealsLink() {
	 		dealslink.click();
	 		return new DealsPage();
	 	}
	 	
	 	public TasksPage clickOnTasksPage() {
	 		taskslink.click();
	 		return new TasksPage();
	 	}
	 	public void clickOnNewContactLink(){
	 		contactslink.click();
	 		newContactLink.click();
	 	}
	 	
}
