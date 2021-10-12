package AutomationTesting.Vivino;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AutomationTesting.Vivino.POM.VivinoHomePage;
import AutomationTesting.Vivino.POM.VivinoResultsPage;
import AutomationTesting.Vivino.POM.VivinoProductdetailspage;

public class VivinoAssignmentTest {
	static ExtentTest test;
	static ExtentReports report;
	Properties p;
	WebDriver driver;
	String searchkeyword;
	String title;
	int numberofResults;
	HashMap<String,List<String>> resultmap;
	String Producttitle;
	String Productcountry;
	String Productlocation;

	 String countyvalue;
	 String locationvalue;
	
	
	
	@BeforeSuite
	public void readPropertyFile() throws IOException{
		report = new ExtentReports("ExtentReportResults.html");
		PropertiesReader pr=new PropertiesReader();
		p=pr.getProerty();
		searchkeyword=p.getProperty("keywrd");
		
	}
	
	@BeforeMethod
	public void setupDriver() throws IOException, AWTException{
		
		BaseDriver bd=new BaseDriver();
		driver=bd.getDriver();	
		driver.get("https://www.vivino.com/");
		title= driver.getTitle();
		Assert.assertEquals(title, "Vivino - Buy the Right Wine");
		CaptureScreenShot.takeScreenShot("vivno");
	}
	
	@Test
	public void dataVerificationTest() throws IOException{
		test = report.startTest("verificationtest");
		test.log(LogStatus.PASS, "Vivino page is displayed");
		VivinoHomePage pcp=new VivinoHomePage(driver);
		VivinoResultsPage vrp=new VivinoResultsPage(driver);
		VivinoProductdetailspage vdp=new VivinoProductdetailspage(driver);
		pcp.setSearchField(searchkeyword);
		pcp.clickEnterkey(searchkeyword);
		numberofResults = vrp.numberofSearchResults();
		System.out.println("results............."+numberofResults);
		resultmap = vrp.SearchResults(numberofResults);
Iterator<Map.Entry<String, List<String>>> itr = resultmap.entrySet().iterator();
        
        while(itr.hasNext())
        {
             Map.Entry<String, List<String>> entry = itr.next();
             System.out.println("Names.. = " + entry.getKey() +       ", locations.. = " + entry.getValue());
             
             for (String s:entry.getValue()) {
		          //  System.out.println("............"+s);
		            if (s==null) {
		            	System.out.println("wine names......"+entry.getKey()+"having no attriburtes");
		            	
		            }
            }
             
        }
		vrp.clickOnProduct();
		 Producttitle = vdp.getTextProduct();
		 Productcountry= vdp.getTextCounry();
		 Productlocation =vdp.getTextlocation();
		 System.out.println("title is..."+Producttitle);
		 System.out.println("country is..."+Productcountry);
		 System.out.println("location is.."+Productlocation);
		Iterator<Map.Entry<String, List<String>>> itr1 = resultmap.entrySet().iterator();
        
        while(itr1.hasNext())
        {
             Map.Entry<String, List<String>> entry = itr1.next();
             
           //  System.out.println("Names.. = " + entry.getKey() +       ", locations.. = " + entry.getValue());
             //System.out.println("prtile............."+Producttitle);
             
             if(entry.getKey().contains(Producttitle)) {
            	 
            	 
            	  locationvalue=  entry.getValue().get(0);
            	  countyvalue=  entry.getValue().get(1);
            	System.out.println("countrytitle"+countyvalue);
            	System.out.println("locationvalue"+locationvalue);
             }
             
            
             
		          //   }
            
          //   for (String s:entry.getValue()) {
           // 	 System.out.println("............"+s);
            	 
          //   }
        }
        Assert.assertEquals(Productcountry, countyvalue);
        Assert.assertEquals(Productlocation, locationvalue);
        
        
        
		
		
		//String landingpage=driver.findElement(By.xpath("//font[contains(text(),'Interactive Amortization Schedule')]")).getText();
		//Assert.assertEquals(landingpage.trim(),"Interactive Amortization Schedule");
		//CaptureScreenShot.takeScreenShot("InteractiveAmortizationSchedule");
		test.log(LogStatus.PASS, "Verified the data");
	}
	

	@AfterMethod
	public void closeBrowser(){
		report.endTest(test);
		driver.close();
	}
	
	@AfterSuite
	public void tearDown(){
		
		report.flush();
	}

}
