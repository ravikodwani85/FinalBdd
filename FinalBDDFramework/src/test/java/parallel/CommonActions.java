package parallel;

import com.Browsers.LocalDriverContext;

import appconstants.AppConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class CommonActions extends BaseSteps {
	
	public void CommonActions()
	{
		System.out.println("initiating Common Actions");
	}
	
	@And("^navigate to url$")
	public void navigatoToUrl()
	{
		LocalDriverContext.getDriver().get(AppConstants.URL);
	}

	@And ("^user clicks on \"([^\"]*)\"$")
	public void userClicksOn(String locator) throws InterruptedException
	{
		getWebElement(locator).click();
	}
	
	
	@Given ("^user enters data \"([^\"]*)\" in textbox \"([^\"]*)\"$")
	public void userEntersDataInTextBox(String value, String locator)
	{
		getWebElement(locator).sendKeys(scenarioData.get().get(value));
	}
}
