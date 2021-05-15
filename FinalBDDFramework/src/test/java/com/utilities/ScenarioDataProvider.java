package com.utilities;

import java.util.Map;

import appconstants.AppConstants;

public class ScenarioDataProvider 
{

	private ScenarioDataProvider() 
	{
		throw new IllegalStateException();
	}

	public static Map<String, String> getData(String testName)
	{
		

		try 
		{
			ExcelUtilities exUtility = new ExcelUtilities(AppConstants.filePath);
			return exUtility.returnData(testName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("no data available for the test in ExcelSheet");
			return null;
		}

	}
}

