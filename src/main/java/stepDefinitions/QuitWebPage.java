package stepDefinitions;

import org.openqa.selenium.support.PageFactory;

import com.aspiration.Locators;
import com.aspiration.base.TestBase;

import io.cucumber.java.en.Then;

public class QuitWebPage extends TestBase {

	Locators locator = PageFactory.initElements(driver, Locators.class);

	@Then("^quit web page$")
	public void quit_web_page() throws Throwable {
		driver.quit();
	}
}
