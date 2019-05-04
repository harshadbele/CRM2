package com.qa.CRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.CRM.Test_Base.Test_Base;

import com.qa.CRM.util.Testutil;

public class Home_Page extends Test_Base {
	
	Testutil  test_url;
	@FindBy (xpath="//a[contains(text(),'Contacts')]") WebElement contacts;
	@FindBy (xpath="//a[contains(text(),'New Contact')]") WebElement new_contact;
	@FindBy (xpath="//a[contains(text(),'Deals')]") WebElement deals;
	@FindBy (xpath="//td[contains(text(),'Harshad Bele')]") WebElement userlabel;

	
	public Home_Page()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String verifypagetitle()
	{
		return driver.getTitle();
	}

	public boolean verifyuserlabel()
	{
 		return userlabel.isDisplayed();
	}
	
	public Contacts_Page clickon_contacts_link()
	{
		contacts.click();
		
		return new Contacts_Page();
	}
	
	public Deals_Page clickon_deals_link()
	{
		deals.click();
		
		return new Deals_Page();
	}
	
	public void click_on_newContacts_link()
	{
		Actions builder=new Actions(driver);
		
		Action series_action=(Action) builder.moveToElement(contacts)
				             .moveToElement(new_contact) 
				             .click()
				             .build();
				             
				             series_action.perform();
		                           			
	}
}
