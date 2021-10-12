package AutomationTesting.Vivino;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseDriver {
public static WebDriver driver;

public WebDriver getDriver() throws IOException{
	
		PropertiesReader pr=new PropertiesReader();
		Properties p=pr.getProerty();
			// TODO Auto-generated method stub
		// Get the browser property from .properties file	
		    String strBrowser=p.getProperty("browser");
			if(strBrowser.equalsIgnoreCase("IE")){
				System.setProperty("webdriver.ie.driver",p.getProperty("IEDriverPath"));
				driver=new InternetExplorerDriver();
			}else if (strBrowser.equalsIgnoreCase("CHROME")){
				System.setProperty("webdriver.chrome.driver",p.getProperty("ChromeDriverPath"));
			       ChromeOptions ops = new ChromeOptions();
	    	       ops.addArguments("--disable-notifications");
	               driver = new ChromeDriver(ops);
			}else if (strBrowser.equalsIgnoreCase("FIREFOX")){
				System.setProperty("webdriver.gecko.driver",p.getProperty("GeckoDriverPath"));
				 driver=new FirefoxDriver();
			}
			// to maximize the window
			driver.manage().window().maximize();
			// this will set the max page load time to 30 sec
			//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			// Implicit wait to 10 se
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// script time out to 10 sec in case of ajax
			driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			

			
			return driver;
}
}
