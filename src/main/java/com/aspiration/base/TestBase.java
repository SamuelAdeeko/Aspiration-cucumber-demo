package com.aspiration.base;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	Properties properties = new Properties();
	public static WebDriver driver;
	private static Logger log = Logger.getLogger(TestBase.class);

	public WebDriver getDriver() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//src//main//resources//chromedriver2");

		if (driver == null) {
			log.info("Initializing step1 chrome driver");
			driver = new ChromeDriver();
			log.info("chrome browser object created");
		}

		return driver;

	}
}
