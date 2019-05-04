package com.qa.CRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.CRM.Test_Base.Test_Base;

public class Deals_Page extends Test_Base{
	
	@FindBy (xpath="//strong[contains(text(),'Company')]") WebElement deals;
    @FindBy (xpath="//select[@name='cs_type']") WebElement type;
    
    public Deals_Page()
    {
    	PageFactory.initElements(driver,this);
    }
    
    
    public boolean verify_page_title()
    {
    	return deals.isDisplayed();
    }
    
    public void select_type_drop_down()
    {
    	Select select=new Select(type);
    	select.selectByVisibleText("New");
    }
}
