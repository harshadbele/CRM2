package com.qa.CRM.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qa.CRM.Test_Base.Test_Base;

public class SignUp_Data extends Test_Base {

	public static String fpath="C:\\Users\\admin\\workspace\\CRM\\New_Contacts.xlsx";
	
	public static XSSFWorkbook xwb;
	public static XSSFSheet sheet;
	
	public static Object[][] readExcel(String sheetname) throws IOException
	{
		File file=new File(fpath);
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			
			xwb=new XSSFWorkbook(fis);
		
		  sheet=xwb.getSheet(sheetname);
		  
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		int total_Rows=sheet.getLastRowNum();
		int total_Cols=sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[total_Rows][total_Cols];
		
		for(int i=0;i<total_Rows;i++)
		{
			for(int j=0;j<total_Cols;j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();			
			}
		}
		
		
		return data;
		
	}
}
