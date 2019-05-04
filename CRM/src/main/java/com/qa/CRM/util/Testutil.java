package com.qa.CRM.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Testutil {
 
	
	public static int pageload_timeout=20;
	public static int implicit_wait=10;
	
	public void switchToFrame(WebDriver driver)
	{
		driver.switchTo().frame("mainpanel"); 
	}
	
	
public static	FileInputStream fis;

	
	static Workbook book;
	static Sheet sheet;
	public static FileInputStream file=null; 
	public static String filepath="C:\\Users\\admin\\workspace\\CRM\\src\\main\\java\\com\\qa\\CRM\\test_data\\CRM.xlsx";
	public static  Object[][] excel_data(String sheetname) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream file = new FileInputStream(filepath);
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
}
