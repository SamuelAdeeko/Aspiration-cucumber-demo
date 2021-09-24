package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;

public class QuitWebPage extends AbstractStepDefinition {

	private WebDriver driver = getDriver();
	
	@Then("^quit web page$")
    public void quit_web_page() throws Throwable {
        driver.quit();
    }
}
