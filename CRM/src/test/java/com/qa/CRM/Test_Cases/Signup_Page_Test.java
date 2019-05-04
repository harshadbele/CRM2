package com.qa.CRM.Test_Cases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.CRM.Test_Base.Test_Base;
import com.qa.CRM.pages.Home_Page;
import com.qa.CRM.pages.Login_page;
import com.qa.CRM.pages.Signup_Page;
import com.qa.CRM.util.SignUp_Data;

public class Signup_Page_Test extends Test_Base {

	Home_Page homePage;
	Login_page loginPage;
	Signup_Page Signup;
	public Signup_Page_Test() {
	super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		loginPage=new Login_page();
		Signup=loginPage.SigupPageLink();
	}
	
	@Test(priority=1)
	public void verifySignUpPageTitle_Test()
	{
		String expected="CRMPRO - CRM Pro for customer relationship management, sales, and support";
	
	    Assert.assertEquals(Signup.verifySignUpPageTitle(), expected);
	}
	
	
	
	@Test(priority=2,dataProvider="testdata")
	public void loadingSignupdata_Test(String fname,String lname,String email_id,String confirm_email,String u_name,String user_pass,String confirm_pass)
	{
	
		Signup.loadingSignupdata(fname, lname, email_id, confirm_email, u_name, user_pass, confirm_pass);
	}
	
	
	@DataProvider
	public Object[][] testdata() throws IOException
	{
	Object[][]	data1=SignUp_Data.readExcel("signup");
		
	return data1;
				
	}
	
	/*
	@DataProvider
	public Object[][] testdata()
	{
		return new Object[][]
				{
			{"Ankush",
			"Dashpute",
			"ankushdashpute@gmail.com",
			"ankushdashpute@gmail.com",
			"Ankush12",
			"Ankush@1",
			"Ankush@1"
				}
			
		};
	}
	*/

	@AfterMethod
	public void teardown()
	{
		driver.close();
	}

}
