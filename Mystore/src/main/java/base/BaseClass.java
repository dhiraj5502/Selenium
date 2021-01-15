/**
 * 
 */
package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import actionDriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author draj
 *
 */
public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	public void loadConfig() throws Exception
	{

		try {
			 prop=new Properties();
			
			//String File ="E://selenium//Udemy//Mystore//Configuration//config.properties";
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	public void launchApp() throws Exception
	{			
		loadConfig();
		prop.getProperty("Browser");
		String test1=prop.getProperty("Url");
System.out.println(test1);
		String BrowserName=prop.getProperty("Browser");
		if(BrowserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
	
		}
		else if(BrowserName.equalsIgnoreCase("FirFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			
		}
		else if(BrowserName.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			
		}
		

		driver.get(prop.getProperty("Url"));
		driver.manage().window().maximize();
		
		
		
	}
	
	public void tearDown()
	{
		driver.close();
	}

}
