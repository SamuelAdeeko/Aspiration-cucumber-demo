package com.aspiration.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
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

			// maximize chrome browser page
			driver.manage().window().maximize();

			// implicit wait for page to load
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			log.info("implicit wait for 3 seconds");

			// create a file input stream
			try {
				FileInputStream inputStream = new FileInputStream(
						"/Users/adekoyaadeeko/Documents/workspace-spring-tool-suite-4-4.8.1.RELEASE"
								+ "/Aspiration-cucumber-demo/src/main/resources/testData.properties");

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
			// log.info("launched website");
		}

		return driver;

	}
}
