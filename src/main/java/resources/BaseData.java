package resources;


import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseData {
	
public WebDriver driver;
public Properties prop;
            public WebDriver initializeDriver() throws IOException {
	

            prop=new Properties();
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//data.properties");
			prop.load(file);
			
			String browserName=prop.getProperty("browser");
			//String browserName=System.getProperty("browser");
			
			if(browserName.contains("chrome")) {
				
				
	            System.setProperty("webdriver.chrome.driver","//Users//fasalurahman//Desktop//chromedriver");
				ChromeOptions options=new ChromeOptions();
				if(browserName.contains("headless")) {
					options.addArguments("headless");
				}
				driver=new ChromeDriver(options);
			}
			else if(browserName.equals("firefox")) {
				//Firefox code
				//driver=new FirefoxDriver();
			}
			else
			{
				Assert.assertTrue(false,"No browser found");
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver;
			
		
            }
            
            
            public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
            	TakesScreenshot ts=(TakesScreenshot)driver;
            	File source=ts.getScreenshotAs(OutputType.FILE);
            	String destinationFile=System.getProperty("user.dir")+"//reports/"+testCaseName+".png";
            	FileUtils.copyFile(source,new File(destinationFile));
            	return destinationFile;
            }
	
}
