package stepDefinitions;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AbstractStepDefinition {

	
	private static WebDriver driver;
	private static Logger log = Logger.getLogger(AbstractStepDefinition.class);
	
	public WebDriver getDriver(){
		 
   	 System.setProperty("webdriver.chrome.driver", "//Users//adekoyaadeeko//Downloads//chromedriver");
		
   	 if(driver == null) {
   		log.info("Initializing chrome driver");
			driver = new ChromeDriver();
		log.info("chrome browser object created");
		}
		
		return driver;
		 
	}
}
