package AutomationTesting.Vivino.POM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class VivinoHomePage {
	
	public WebDriver driver;
	
	public static final By txt_searchfield=By.xpath("//input[@name='q']");
	public static final By search_resultsfield=By.xpath("//div[@class='card card-lg']");
	
	//driver.findElement(By.xpath("//div[@class='card card-lg']["+i+"]//span[@class='bold']")).getText();
    //System.out.p
	public VivinoHomePage(WebDriver driver){
		this.driver=driver;
	}
	
	public void clickEnterkey(String increaseYears){
		driver.findElement(txt_searchfield).sendKeys(Keys.ENTER);
	}
	
	public void setSearchField(String searchText){
		driver.findElement(txt_searchfield).clear();
		driver.findElement(txt_searchfield).sendKeys(searchText);
	}
	
				
	
}
