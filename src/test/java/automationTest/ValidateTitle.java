package automationTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.BaseData;

public class ValidateTitle extends BaseData {
	public static Logger log=LogManager.getLogger(ValidateTitle.class.getName());
	
	public WebDriver driver;
	
	
	@BeforeTest
	public void initial() throws IOException {
		driver=initializeDriver();
		
	}

	@Test
	public void getTitle() throws InterruptedException {
		
		driver.get(prop.getProperty("url"));
			
		LandingPage l=new LandingPage(driver);
		
		l.acceptCookie().click();
		Thread.sleep(2000);
			
		Assert.assertEquals(l.getHeader().getText(), "The Sales Hub by Salesforce123");//deliberately making it fail to take screenshot on failure
		log.info("Successfully validated the text");
		
		
		
	}
	@AfterTest
	public void close() {
		
		driver.close();
	}
	
}
