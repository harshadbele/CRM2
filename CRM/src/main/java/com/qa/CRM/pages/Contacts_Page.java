package com.qa.CRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.CRM.Test_Base.Test_Base;

public class Contacts_Page extends Test_Base{


	@FindBy (xpath="//td[contains(text(),'Contacts')]") WebElement contacts;
	@FindBy (id="first_name") WebElement firstname;
	@FindBy (id="surname") WebElement lastname;
	@FindBy (xpath="//input[@name='client_lookup']") WebElement comp;
	@FindBy (xpath="//form[@id='contactForm']/table/tbody/tr[1]/td/input[2]") WebElement save;
	
	
	public Contacts_Page()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public boolean Verify_Contacts_Page_Title()
	{
		return contacts.isDisplayed();
	}
	
	public void Selecting_Contacts()
	{
	 driver.findElement(By.xpath("//form[@id='vContactsForm']/table/tbody/tr[5]/td/input")).click();
	}
	
	
	public void create_New_Conact(String title,String fname,String lname,String company)
	{
		Select select=new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(title);
		
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		comp.sendKeys(company);
		save.click();
	}
}
