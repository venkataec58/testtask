package AutomationTesting.Vivino.POM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VivinoResultsPage {
	public WebDriver driver;
	public static final By search_resultsfield=By.xpath("//div[@class='card card-lg']");
	public static final By txt_Productfield=By.xpath("//div[@class='card card-lg'][2]//span[@class='bold']");
	
	public VivinoResultsPage(WebDriver driver){
		this.driver=driver;
	}

	
	public int numberofSearchResults(){
		//n= 0;
		 int n = driver.findElements(search_resultsfield).size();
		///driver.findElement(txt_searchfield).clear();
		return n;
		///driver.findElement(txt_searchfield).sendKeys(searchText);
	}
	
	public HashMap<String, List<String>> SearchResults(int nu){
		//n= 0;
		
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i=1;i<=nu;i++) {
			String Vname= driver.findElement(By.xpath("//div[@class='card card-lg']["+i+"]//span[@class='bold']")).getText();
	        //System.out.println("name............"+Vname);
	        
	        List<String> location = new ArrayList<String>();
	        for (int j=1; j<=2;j++) {
	        	
	        	boolean el = driver.findElements(By.xpath("//div[@class='card card-lg'][" +i+"]//span[@class='text-block wine-card__region']//a[@class='link-color-alt-grey']["+j+"]")).size()>0; 
	        	
	        	if (el) {
	        		String loc= driver.findElement(By.xpath("//div[@class='card card-lg'][" +i+"]//span[@class='text-block wine-card__region']//a[@class='link-color-alt-grey']["+j+"]")).getText();
	        		//System.out.println("location........."+loc);

location.add(loc);

	        		
	        	} else {
	        		

location.add(null);
	        	}
	        	//boolean si= driver.findElements(By.id("myId")).size()>0;
	        	
	        	//System.out.println("size2222222222............"+si);
	        	//System.out.println("erereeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	        	//System.out.println("size........."+el.getSize());
	        		        	
	        }
	        
	       // 
	        
	        map.put(Vname, location);
	        
	      //  return map;
	       // System.out.println("map..............."+map);
			 // Iterator<Map.Entry<String, List<String>>> itr = map.entrySet().iterator();
		         
		     //   while(itr.hasNext())
		      //  {
		           //  Map.Entry<String, List<String>> entry = itr.next();
		           //  System.out.println("Key = " + entry.getKey() +
		                       //          ", Value = " + entry.getValue());
		          //   for (String s:entry.getValue()) {
		           // 	 System.out.println("............"+s);
		            	 
		          //   }
		       // }
	      	        
		}
		return map;
		
		
	    
	

		// int n = driver.findElements(search_resultsfield).size();
		///driver.findElement(txt_searchfield).clear();
		//return n;
		///driver.findElement(txt_searchfield).sendKeys(searchText);
	}
	
	public void clickOnProduct(){
		driver.findElement(txt_Productfield).click();
	}

}
