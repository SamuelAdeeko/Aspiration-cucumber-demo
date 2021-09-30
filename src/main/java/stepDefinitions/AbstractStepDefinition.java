package stepDefinitions;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class AbstractStepDefinition {

	Properties properties = new Properties();
	private static WebDriver driver = null;
	private static Logger log = Logger.getLogger(AbstractStepDefinition.class);
	
	public WebDriver getDriver(){
		 
   	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//chromedriver2"); 
   
   	 if(driver == null) {
   		log.info("Initializing step1 chrome driver");
			driver = new ChromeDriver();
		log.info("chrome browser object created");
		}
		
		return driver;
		 
	}
}
