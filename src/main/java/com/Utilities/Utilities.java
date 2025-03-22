package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.CellType;


public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=5;
	
	public static String generateTimeStamp() 
	{
		Date  date =new Date();
		String timestamp= date.toString().replace(" ", "_").replace(":", ".");
		return "shubhammsemaskar"+timestamp+"@gmail.com";
	}


	public static void getTestDataFromExcel(String sheetName)
	{
		
		File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Utilities\\testdata.xlsx");
		XSSFWorkbook workbook = null;
		try {
			FileInputStream fisExcel = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fisExcel);
		}catch(Throwable e) {
			e.printStackTrace();
		}
			
			XSSFSheet sheet= workbook.getSheet(sheetName);
			
			int rows=sheet.getLastRowNum();
			int cols=sheet.getRow(0).getLastCellNum();
			
			Object[][] data=new Object[rows][cols];
			
			for(int i=0;i<rows;i++)
			{
				XSSFRow row=sheet.getRow(i+1);
				
				for(int j=0;j<cols;j++)
				{
					XSSFCell cell=row.getCell(j);
					org.apache.poi.ss.usermodel.CellType cellType =cell.getCellType();
				
					switch(cellType)
					{
					case STRING:
					data[i]	[j]=cell.getStringCellValue();
					break;
					case NUMERIC:
						data[i][j] = Integer.toString((int)cell.getNumericCellValue());
						break;
					case BOOLEAN:
						data[i][j] = cell.getBooleanCellValue();
						break;	
			
					}
					
				}
				
			}
			
			
			
		}
		
}
		
