package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

public class ExcelUtilities 
{

	private String path = null;
	private Workbook wbook = null;
	private Sheet sheet = null;

	public ExcelUtilities(String filepath) 
	{
		path = filepath;
		wbook = getWorkBook(path);

	}

	public Workbook getWorkBook(String path)
	{
		File file = new File(path);
		if(file.exists()) 
		{
			try
			{
				if( file.getName().endsWith(".xlsx"))
				{
					FileInputStream input = new FileInputStream(file);
					wbook = new XSSFWorkbook(input);
					return wbook;
				}
				
				else
				{
					FileInputStream input = new FileInputStream(file);
					wbook = new HSSFWorkbook();
					return wbook;
				}
			}
			
		catch(Exception e)
			{
			e.printStackTrace();
			System.out.println("File is not loaded/found");
			return null;
		
			}
		}
		return null;
	}
	
	
	public Map<String, String> returnData(String testName) throws IOException
	{
		
		HashMap<String, String> dataRet = new HashMap<String, String>();
		
		if(sheet.getRow(0).getCell(0).getStringCellValue()=="")
		{
			System.out.println("Test data sheet is blank");
			wbook.close();
			System.exit(0);
		}
		else
		{
			System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
			int rowTotal = sheet.getLastRowNum();
			
			for (int i = 0; i<rowTotal; i++)
			{
				if(sheet.getRow(i).getCell(0).getStringCellValue().equals(testName))
				{
					int columnCount = sheet.getRow(i+1).getLastCellNum();
					if(columnCount==0)
					{
						Assert.fail("no data available for scenario");
						return null;
					}
					else
					{
						for(int j=0; j<columnCount;j++)
						{
							System.out.println(sheet.getRow(i+1).getCell(j).getStringCellValue());
							System.out.println(sheet.getRow(i+2).getCell(j).getStringCellValue());
							dataRet.put(sheet.getRow(i+1).getCell(j).getStringCellValue().trim(), sheet.getRow(i+2).getCell(j).getStringCellValue().trim());
												
						}
					}
				}
			}
		
		}
		
		wbook.close();
		return dataRet;
		
	}

}
