
package parallel;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Browsers.BrowserFactory;
import com.Browsers.LocalDriverContext;
import com.utilities.CommonUtils;

import appconstants.AppConstants;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;


public class CucumberHooks {

	private Logger log;
	
	@Before
	public void setup(Scenario scenario)
	{
		log = Logger.getLogger(scenario.getName());
		System.out.println(scenario.getName());
		WebDriver driver = BrowserFactory.getDriver();
		driver.manage().window().maximize();
		LocalDriverContext.setDriver(driver);
		BaseSteps basesteps = new BaseSteps();
		basesteps.setScenario(scenario);
		basesteps.setScenarioData();
		CommonUtils.clearDirectory(AppConstants.filePath);
		log.info("started execution of scenario:>****" + scenario.getName()+ " ****");
		
	}
	
	@AfterStep
	public void addScreenshotOnFailure(Scenario scenario)
	{
		if (scenario.isFailed())
		{
		log.info("Scenario: "+ scenario.getName()+ " is failed");
		TakesScreenshot scrShot = ((TakesScreenshot)LocalDriverContext.getDriver());
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(AppConstants.ScreenShotPath+scenario.getName()+".png");
		try
		{
			FileUtils.copyFile(SrcFile, DestFile);
		}
		catch(IOException e)
		{
			log.info("could not capture screenshot");
			e.printStackTrace();
		}
		
		}
	}
	
	@After
	public void completion(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			log.info("Scenario: "+scenario.getName()+ " is Failed");
		}
		
		log.info("Finnished execution of scenario : >***" + scenario.getName() + " ***");
		log.info("[Closing driver]");
		
		if(LocalDriverContext.getDriver()!= null)
		{
			LocalDriverContext.getDriver().quit();
		}
		
	}
	
}
