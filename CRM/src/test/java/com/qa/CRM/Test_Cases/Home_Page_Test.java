package com.qa.CRM.Test_Cases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.CRM.Test_Base.Test_Base;
import com.qa.CRM.pages.Contacts_Page;
import com.qa.CRM.pages.Deals_Page;
import com.qa.CRM.pages.Home_Page;
import com.qa.CRM.pages.Login_page;
import com.qa.CRM.util.Testutil;


public class Home_Page_Test extends Test_Base{
	Login_page loginPage;
	Home_Page homePage;
	Contacts_Page contactsPage;
	Deals_Page dealsPage;
	public static Testutil testutil;
	
	
	public Home_Page_Test() {
	super();	
	}

	@BeforeMethod
	public void setup()
	{
		intialization();
		loginPage=new Login_page();
		testutil=new Testutil();
		homePage=loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void Test_verifypagetitle()
	{
	String homepagetitle=homePage.verifypagetitle();
	
	Assert.assertEquals(homepagetitle,"CRMPRO","Title is wrong");
	}
	
	@Test(priority=2)
	public void Test_verifyuserlabel()
	{
		testutil.switchToFrame(driver);
	Assert.assertTrue(homePage.verifyuserlabel());
	}
	
	@Test(priority=3)
	public void Test_clickon_contacts_link()
	{
		testutil.switchToFrame(driver);
		contactsPage=homePage.clickon_contacts_link();
	}
	
	@Test(priority=4)
	public void Test_clickon_deals_link()
	{
		testutil.switchToFrame(driver);
		dealsPage=homePage.clickon_deals_link();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
