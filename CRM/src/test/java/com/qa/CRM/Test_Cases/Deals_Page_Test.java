package com.qa.CRM.Test_Cases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.CRM.Test_Base.Test_Base;
import com.qa.CRM.pages.Deals_Page;
import com.qa.CRM.pages.Home_Page;
import com.qa.CRM.pages.Login_page;
import com.qa.CRM.util.Testutil;

public class Deals_Page_Test extends Test_Base{

	Login_page loginPage;
	Home_Page homePage;
	Testutil testutil;
	Deals_Page dealsPage;
	
	public Deals_Page_Test() {
	super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		loginPage=new Login_page();
		homePage=new Home_Page();
		testutil=new Testutil();
		dealsPage=new Deals_Page();
		
		homePage=loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
		testutil.switchToFrame(driver);
		dealsPage=homePage.clickon_deals_link();
	}
	
	@Test(priority=1)
	public void Test_verify_page_title()
	{
		Assert.assertTrue(dealsPage.verify_page_title());
	}
	
	@Test(priority=2)
	public void Test_select_type_drop_down()
	{
		dealsPage.select_type_drop_down();
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
