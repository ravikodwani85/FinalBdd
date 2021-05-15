package com.utilities;

import java.io.File;
import java.util.Map;

public class CommonUtils {
	
	public static Map<String, String> getData (String testName, ExcelUtilities excelUtil) throws Throwable
	{
		return excelUtil.returnData(testName);
	}

	public static boolean clearDirectory(String dirPath)
	{
		boolean flag = false;
		File file = new File(dirPath);
		if(file.isDirectory())
		{
			File[] fileList = file.listFiles();
			for(File files:fileList)
			{
				files.delete();
			}
			
			flag = true;
		}
		
	
		return flag;
		
	}
	
}
