package com.inetbanking.utilities;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class XLtestdata {
	WebDriver driver;
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	
	DataFormatter formatter= new DataFormatter();

	@DataProvider(name="getdata")
	  public Object[][] getdata() throws IOException {
		  File f= new File(System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx");
		  fis = new FileInputStream(f);
		  workbook = new XSSFWorkbook(fis);
		  sheet = workbook.getSheetAt(0);
		  Row row1 = sheet.getRow(0);
		  
		  int RowNum = sheet.getPhysicalNumberOfRows();
	  	  int ColNum= row1.getLastCellNum(); 
	  	
	  	Object Data[][]= new Object[RowNum-1][ColNum]; 
	  	
	   for(int i=0; i<RowNum-1; i++) 
	   {  
	   Row row= sheet.getRow(i+1);
	   
	   for (int j=0; j<ColNum; j++) 
	   {
	   if(row==null)
	   Data[i][j]= "";
	   else 
	   {
	   Cell cell= row.getCell(j);
	   if(cell==null)
	   Data[i][j]= "";                                        //if it get Null value it pass no data 
	   else
	   {
	   String value=formatter.formatCellValue(cell);
	   Data[i][j]=value;                                      //This formatter get my all values as string i.e integer, float all type data value
	   }
	   }
	   }
	   }

	  	return Data;
	  }

	   
	  
  }

