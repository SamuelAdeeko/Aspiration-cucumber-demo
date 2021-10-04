package com.aspiration;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aspiration.base.TestBase;

public class Locators extends TestBase {

	public WebDriver driver;

	public Locators(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='join-waitlist-input']")
	private WebElement emailField;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-v3 btn--blue ng-binding']")
	private WebElement aspirationCards;
	@FindBy(how = How.XPATH, using = "//div[@class='modal-content']")
	private WebElement modal;
	@FindBy(how = How.XPATH, using = "//b[@class= 'ng-binding']")
	private WebElement radioButton;
	@FindBy(how = How.XPATH, using = "//button[@id ='onetrust-accept-btn-handler']")
	private WebElement cookie;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Spend & Save")
	private WebElement saveAndSpend;

	public WebElement emailField() {

		return emailField;
	}

	public List<WebElement> aspirationCard() {

		return driver.findElements(By.xpath("//button[@class='btn btn-v3 btn--blue ng-binding']"));

	}

	public WebElement modal() {

		return modal;
	}

	public List<WebElement> getRadioButton() {

		return driver.findElements(By.xpath("//b[@class= 'ng-binding']"));
	}

	public List<WebElement> aspirationPage() {

		return driver.findElements(By.xpath("//div[@class = 'plan-content']/h2"));
	}

	public WebElement cookie() {

		return cookie;

	}

	public WebElement saveAndSpend() {

		return saveAndSpend;
	}

}
