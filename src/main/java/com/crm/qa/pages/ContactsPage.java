package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy (xpath="//div[@class='ui header item mb5 light-black']")
	@CacheLookup
	WebElement contactsLable;
	
	@FindBy(name="first_name")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
	WebElement company;
	
	@FindBy (xpath="//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	//Initialization 
 	public ContactsPage () {
 		PageFactory.initElements(driver, this);
 	}
	
 	public boolean verifyContctsLabel() {
 		return contactsLable.isDisplayed();
 	}
 	
 	public void selectContactsByName(String Name) {
 		driver.findElement(By.xpath("//td[contains(text(),'"+Name+"')]")).click();
 	}
 	
 	public void creatNewContact(String ftName, String ltName, String comp) {
 		firstName.sendKeys(ftName);
 		lastName.sendKeys(ltName);
 		company.sendKeys(comp);
 		saveBtn.click();
 	}

}
