package com.qa.CRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.CRM.Test_Base.Test_Base;

public class Login_page extends Test_Base {

	@FindBy (name="username") WebElement username;
	@FindBy (name="password") WebElement password;
	@FindBy (xpath="//input[@value='Login']") WebElement loginBtn;
	@FindBy (xpath="//a[@href='https://www.crmpro.com/register/']") WebElement signuplink;

	public Login_page()
	{
		PageFactory.initElements(driver,this);

	}

	public String Validate_loginTitle()
	{
	         return driver.getTitle();
	}
	
	public Signup_Page SigupPageLink()
	{
		signuplink.click();
		
		return new Signup_Page();
	}
	public Home_Page Login(String usrn,String pswd)
	{
		username.sendKeys(usrn);
		password.sendKeys(pswd);
		loginBtn.click();
		
		 
		return new Home_Page();
		
	}
}
