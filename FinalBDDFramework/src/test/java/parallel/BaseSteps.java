package parallel;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.Browsers.LocalDriverContext;
import com.utilities.ScenarioDataProvider;
import com.utilities.Waits;

import cucumber.api.Scenario;

public class BaseSteps {

	static ThreadLocal<Scenario> scenario = new ThreadLocal<Scenario>();
	static ThreadLocal<Map<String, String>> scenarioData= new ThreadLocal<Map<String,String>>();
	
	public void setScenario(Scenario sc) {
		scenario.set(sc);
	}
	
	public void setScenarioData() {
		System.out.println(scenario.get().getName());
		System.out.println(scenarioData.get());
		
		scenarioData.set(ScenarioDataProvider.getData(scenario.get().getName()));
		Assert.assertTrue("***TestCase :"+scenario.get().getName()+" doesn't have any test data in excel", scenarioData.get().size()>0);		
	}
	
	public WebElement getWebElement(String Locator)
	{
		String xpath = getXpath(Locator);
		 Wait wait = null;
		 try
		 {
			 wait = Waits.returnFluentWait(LocalDriverContext.getDriver());
		 }
		 
		 catch(Exception E)
		 {
			 System.out.println("getting error in wait");
		 }
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		 
		 WebElement wb = LocalDriverContext.getDriver().findElement(By.xpath(xpath));
		 
		 return wb;
	}
	
	
	
	public String getXpath(String Locator)
	{
		
		String[] abc = Locator.split("\\.");
		try
		{
			String clazz = abc[0].replace("#", "");
			Class<?> act = Class.forName("com.pages."+clazz);
			return (String) act.getDeclaredField(abc[1]).get(act);	
		}
		
		catch(Exception e)
		{
			System.out.println("no such field "+abc[1]+" available in class: "+abc[0]);
			return null;
		}
	}
	
	
	public String getVariableValue(String Variable)
	{
		if(Variable.startsWith("#"))
		{
			return scenarioData.get().get(Variable.replace("#", ""));
			
		}
		
		else
		{
			System.out.println(scenario.get().getName()+ " "+ Variable + " this variable doesn't exist as it doesn't starts with #");
			return null;
		}
	}
}
