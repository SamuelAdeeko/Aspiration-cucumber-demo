package stepDefinitions;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aspiration.Locators;
import com.aspiration.base.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductPageSteps extends TestBase {

	WebDriver driver = getDriver();
	private static Logger log = Logger.getLogger(ProductPageSteps.class);
	Locators locator = PageFactory.initElements(driver, Locators.class);

	@Given("^After verifying Get Aspiration is displayed$")
	public void after_verifying_get_aspiration_is_displayed() throws Throwable {

		List<WebElement> element = new ArrayList<>();

		element = locator.aspirationCard();
		boolean isFalse = element.get(0).isDisplayed();
		Assert.assertTrue(isFalse);
		log.info("Get Aspirations is displayed");
	}

	@When("^User click on Get Aspiration$")
	public void user_click_on_get_aspiration() throws Throwable {

		List<WebElement> element = new ArrayList<>();

		element = locator.aspirationCard();
		element.get(0).click();

		log.info("clicked on Get Aspirations");
	}

	@Then("^A modal containing an input field for email address to sign up appears$")
	public void a_modal_containing_an_input_field_for_email_address_to_sign_up_appears() throws Throwable {

		boolean isFalse = locator.emailField().isDisplayed();
		assertTrue(isFalse);
		log.info("modal contains email address input fields");

	}

	@Given("^User goes back to Homepage$")
	public void user_goes_back_to_homepage() throws Throwable {

		driver.navigate().back();
		log.info("Navigated to previous product page.");
	}

	@When("^User clicks on spend and save link$")
	public void user_clicks_on_spend_and_save_link() throws Throwable {

		locator.saveAndSpend().click();
		log.info("clicked spend and save");
	}

	@And("^User clicks on Get Aspiration plus$")
	public void user_clicks_on_get_aspiration_plus() throws Throwable {

		List<WebElement> element = new ArrayList<>();

		element = locator.aspirationCard();
		element.get(1).click();

		log.info("clicked on Get Aspirations Plus");
	}

	@Then("^User verify that monthly and yearly modal appears$")
	public void user_verify_that_monthly_and_yearly_modal_appears() throws Throwable {

		boolean isFalse = locator.modal().isDisplayed();

		Assert.assertTrue(isFalse);
		log.info("Aspiration plus Modal is displayed");
	}

	@And("^User verify that yearly radio option is \"([^\"]*)\" paid once yearly$")
	public void user_verify_that_yearly_radio_option_is_something_paid_once_yearly(String strArg1) throws Throwable {

		List<WebElement> rButton = new ArrayList<>();

		rButton = locator.getRadioButton();
		String nText = rButton.get(0).getText();
		log.info("nText == " + nText);
		assertEquals("$71.88", nText);
	}

	@And("^User verify that monthly radio option is \"([^\"]*)\" paid monthly$")
	public void user_verify_that_monthly_radio_option_is_something_paid_monthly(String strArg1) throws Throwable {

		List<WebElement> rButton = new ArrayList<>();

		rButton = locator.getRadioButton();
		String rText = rButton.get(1).getText();
		log.info("rText == " + rText);
		assertEquals("$7.99", rText);

	}

	public void quitWebPage() {
		// close browser
		driver.quit();
	}

}
