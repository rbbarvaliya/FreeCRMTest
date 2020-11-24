package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger log;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(TestUtil.CONFIG_PROPERTIES_PATH);
			prop.load(ip);	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace(); 
		}  
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")){
		    System.setProperty("webdriver.chrome.driver","C:\\Users\\ravin\\Downloads\\chromedriver.exe");
		    driver = new ChromeDriver();
		}else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\ravin\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
	}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
//		To generate logs
		log = Logger.getLogger("Log4jforFREECRM");
		PropertyConfigurator.configure("log4j.properties");
		
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLIIT_WAIT, TimeUnit.SECONDS);
	    
	    driver.get(prop.getProperty("url"));
	
}

    
}
