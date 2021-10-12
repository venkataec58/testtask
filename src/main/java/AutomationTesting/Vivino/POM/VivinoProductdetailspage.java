package AutomationTesting.Vivino.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VivinoProductdetailspage {
	
	public WebDriver driver;
	public static final By txt_Productname=By.xpath("//div[@class='row header breadCrumbs']//a[@class='winery']");
	public static final By txt_countryname=By.xpath("//div[@class='breadCrumbs__breadCrumbs--2pkcX']//span[1]//a[@class='anchor__anchor--3DOSm breadCrumbs__link--1TY6b'][1]");
	public static final By txt_locname=By.xpath("//div[@class='breadCrumbs__breadCrumbs--2pkcX']//span[2]//a[@class='anchor__anchor--3DOSm breadCrumbs__link--1TY6b'][1]");
	
	public VivinoProductdetailspage(WebDriver driver){
		this.driver=driver;
	}

	
	
	public String getTextProduct(){
		String title = driver.findElement(txt_Productname).getText();
		return title;
		
	}
	
	public String getTextCounry(){
		String country = driver.findElement(txt_countryname).getText();
		return country;
		
	}
	
	public String getTextlocation(){
		String location = driver.findElement(txt_locname).getText();
		return location;
		
	}
	
	
}
