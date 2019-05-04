package com.qa.CRM.Test_Cases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.CRM.Test_Base.Test_Base;
import com.qa.CRM.pages.Contacts_Page;
import com.qa.CRM.pages.Home_Page;
import com.qa.CRM.pages.Login_page;
import com.qa.CRM.util.SignUp_Data;
import com.qa.CRM.util.Testutil;

public class Contacts_Page_Test extends Test_Base{

	public  Login_page loginPage;
	public  Home_Page homePage;
	public  Testutil textutil;
	public Contacts_Page contactsPage;
	public String sheetname="contacts";
	
	public Contacts_Page_Test()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		loginPage=new Login_page();
		homePage=new Home_Page();
		textutil=new Testutil();
		contactsPage=new Contacts_Page();
		homePage=loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
		textutil.switchToFrame(driver);
		homePage.clickon_contacts_link();
	}
	
	@Test(priority=1)
	public void Test_Verify_Contacts_Page_Title()
	{
      Assert.assertTrue(contactsPage.Verify_Contacts_Page_Title());
	}
	
	@Test(priority=2)
	public void Test_Selecting_Contacts()
	{
		contactsPage.Selecting_Contacts();
	}
	
	
	@Test(priority=3,dataProvider="getCRMData")
	
	public void Test_create_New_Conact(String title,String fname,String lname,String company)
	{
		homePage.click_on_newContacts_link();
		contactsPage.create_New_Conact(title,fname,lname,company);
	}
	
	@DataProvider
	public Object[][] getCRMData() throws EncryptedDocumentException, IOException
	{
		Object data[][]=SignUp_Data.readExcel("NewContact");
		return data;
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
