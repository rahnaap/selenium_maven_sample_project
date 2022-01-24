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

public class ValidateNavigationBar extends BaseData{
	public static Logger log=LogManager.getLogger(ValidateNavigationBar.class.getName());
	public WebDriver driver;
	LandingPage l;
	
	@BeforeTest
	public void initial() throws IOException {
		driver=initializeDriver();
		
	}
	
	@Test
    public void getNavigationBar() {
	
	
	
	driver.get(prop.getProperty("url"));
	l=new LandingPage(driver);
	
    l.acceptCookie().click();
		
	
	//checking navigation bar is present 
	
	Assert.assertTrue(l.getNav().isDisplayed());
	log.info("Navigation bar is displayed");
	}
	
	@Test
	public void validateLogo() {
	Assert.assertTrue(l.getLogo().isDisplayed());
	log.info("Logo is displayed");	
	}
	
	@AfterTest
	public void close() {
		
		driver.close();
	}
	}
	
	

