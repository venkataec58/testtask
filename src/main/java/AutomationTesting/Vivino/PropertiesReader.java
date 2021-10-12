package AutomationTesting.Vivino;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
	public Properties getProerty() throws IOException{
		FileReader fl=new FileReader("SeleniumProperties.properties");
		BufferedReader reader=new BufferedReader(fl);
		Properties p=new Properties();
		p.load(reader);
		
		return p;
	}

}
