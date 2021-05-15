package appconstants;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class AppConfig
{

	private AppConfig() 
	{
		throw new IllegalStateException();

	}

	public static String getProperty(String property){
		{
			try
			{
				FileInputStream fis = new FileInputStream("../FinalBDDFramework/src/test/resources/Constants/AppConstants.properties");
				Properties prop = new Properties();
				prop.load(fis);
				return(prop.getProperty(property));
			}
				catch(Exception e)
				{
					e.printStackTrace();
					Logger.getLogger("Either property file is not available or property" + property + "is not available");
					return null;
				}
			}

		}


	}
