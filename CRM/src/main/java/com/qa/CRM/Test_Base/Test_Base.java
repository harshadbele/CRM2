package com.qa.CRM.Test_Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.qa.CRM.util.Testutil;

public class Test_Base {

	public static WebDriver driver;
	public static Properties prop;
	public static String src="C:\\Users\\admin\\workspace\\CRM\\src\\main\\"
			+ "java\\com\\qa\\CRM\\config\\config.properties";
	
	public Test_Base()
	{

  try{
		FileInputStream fis=new FileInputStream(src);
		prop=new Properties();
		prop.load(fis);
		
	}
	catch(FileNotFoundException e)
	{
		e.getMessage();
	}
	catch(IOException e)
	{
		e.getMessage();
	}
	}
	
	public static void intialization()
	{
		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","c://chromedriver.exe");
			
			driver=new ChromeDriver();
			driver.get(prop.getProperty("url"));
				}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Testutil.pageload_timeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.implicit_wait,TimeUnit.SECONDS);
		
	}
}
