package com.qa.CRM.Test_Cases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.CRM.Test_Base.Test_Base;
import com.qa.CRM.pages.Home_Page;
import com.qa.CRM.pages.Login_page;

public class Login_Page_Test extends Test_Base {
	
	Login_page loginPage;
	Home_Page homePage;
	public Login_Page_Test()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		loginPage=new Login_page();
		
	}
	
	@Test(priority=1)
	public void test_loginTitle()
	{
	String expectedtitle=loginPage.Validate_loginTitle();
	String actualtitle="CRMPRO - CRM software for customer relationship management, sales, and support.";
		Assert.assertEquals(expectedtitle,actualtitle);
	}
	
	@Test(priority=2)
	public void test_Login()
	{
		homePage=loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
		
		
	}

	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
