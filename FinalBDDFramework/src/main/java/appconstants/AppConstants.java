package appconstants;

public class AppConstants {
	
	private AppConstants()
	{
		throw new IllegalStateException();
	}

	public static final String URL = AppConfig.getProperty("Url");
	public static final String USER_DIRECTORY = "C:\\FinalBdd";
	
	public static final String filePath = AppConfig.getProperty("excelFilePath");
	public static final String BrowserType = AppConfig.getProperty("Browser");
	public static final String ScreenShotPath = AppConfig.getProperty("ScreenShotPath");
	
}
