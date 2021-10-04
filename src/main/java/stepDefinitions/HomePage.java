package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

public class HomePage extends TestBase {

	WebDriver driver = getDriver();
	private static Logger log = Logger.getLogger(HomePage.class);
	// Properties properties = new Properties();
	Locators locator = PageFactory.initElements(driver, Locators.class);

	@Given("^visit the homepage \"([^\"]*)\"$")
	public void visit_the_homepage_something(String strArg1) throws Throwable {

		// maximize chrome browser page
		driver.manage().window().maximize();

		// create a file input stream
		try {
			FileInputStream inputStream = new FileInputStream("./src/main/resources/testData.properties");

			try {
				// read the file
				properties.load(inputStream);
			} catch (IOException e) {
				log.info(e);
			}
		} catch (FileNotFoundException e) {
			log.info(e);
		}

		// get the value of the property using its key 'url'
		String url = properties.getProperty("url");

		// get website url
		driver.get(url);
		log.info("launched website");

	}

	@When("^User click to accept cookie$")
	public void user_click_to_accept_cookie() throws Throwable {

		log.info("about to accept cookie");
		locator.cookie().click();
		log.info("accepted cookie");
	}

	@And("^User navigates to the Spend and Save link and click$")
	public void user_navigates_to_the_spend_and_save_link_and_click() throws Throwable {

		locator.saveAndSpend().click();
		log.info("clicked spend and save");
	}

	@Then("^User should be able to view Products and prices$")
	public void user_should_be_able_to_view_products_and_prices() throws Throwable {

		List<WebElement> element = new ArrayList<>();

		element = locator.aspirationPage();
		String product1 = element.get(0).getText();
		String product2 = element.get(1).getText();
		String actualProduct = "Aspiration";
		String actualProduct1 = "Aspiration Plus";
		log.info(product1);
		log.info(product2);

		// verify the 2 products using assertEquals

		Assert.assertEquals(actualProduct, product1);
		Assert.assertEquals(actualProduct1, product2);

	}

}
