package com.qa.CRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.CRM.Test_Base.Test_Base;

public class Signup_Page extends Test_Base{

	
	@FindBy (xpath="//*[@name='first_name']") WebElement fname;
	@FindBy (xpath="//*[@name='surname']") WebElement lname;
	@FindBy (xpath="//*[@name='email']") WebElement email;
	@FindBy (xpath="//*[@name='email_confirm']") WebElement con_email;
	@FindBy (xpath="//*[@name='username']") WebElement username;
	@FindBy (xpath="//*[@name='password']") WebElement pass;
	@FindBy (xpath="//*[@name='passwordconfirm']") WebElement con_pass;
	@FindBy (xpath="//*[@name='agreeTerms']") WebElement checkbox;
	
	
	public Signup_Page() {
	PageFactory.initElements(driver, this);
	}
	
	
	
	
	public String verifySignUpPageTitle()
	{
		return driver.getTitle();
		
	}
	
	public void loadingSignupdata(String firstname,String lastname,String email_id,String confirm_email,String u_name,String user_pass,String confirm_pass)
	{
		
		Select select=new Select(driver.findElement(By.xpath("//select[@name='payment_plan_id']")));
		select.selectByVisibleText("Free Edition");
	
		fname.sendKeys(firstname);
	     
		lname.sendKeys(lastname);
		
		email.sendKeys(email_id);
		
		con_email.sendKeys(confirm_email);
		
		username.sendKeys(u_name);

		pass.sendKeys(user_pass);
		
		con_pass.sendKeys(confirm_pass);
		
		checkbox.click();
	}
	
}
