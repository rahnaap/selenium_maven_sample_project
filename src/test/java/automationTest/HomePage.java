package automationTest;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BaseData;

public class HomePage extends BaseData {
	public static Logger log=LogManager.getLogger(HomePage.class.getName());
	
	
	public WebDriver driver;//to avoid overriding driver while executing tests in parallel mode
	public boolean acceptCookieClicked = false;
	
	@BeforeTest
	public void initial() throws IOException {
		driver=initializeDriver();
		log.info("Driver is intialized");
		
	}
	
	@Test(dataProvider="getData")
    public void basePageNavigation(String username,String password) {
	
	
	
	driver.get(prop.getProperty("url"));
	
	LandingPage l=new LandingPage(driver);
	if(!acceptCookieClicked) {
		l.acceptCookie().click();
		acceptCookieClicked = true;
	}
	log.info("Successfully navigated to home page");
	
	LoginPage lp=l.getLogin();
	
	
	lp.getUsername().sendKeys(username);
	lp.getPassword().sendKeys(password);
	lp.login().click();
	log.info("Tried to login using invalid credentials");
	
}
	
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data=new Object[2][2];
		
		//try to login with multiple set of invalid credentials
		//login with invalid credentials
		data[0][0]="rahn123";
		data[0][1]="123456";
		
		//login with invalid credentials
		data[1][0]="fasal234";
		data[1][1]="4567890e3";
		
		return data;
		
	}
	@AfterTest
	public void close() {
		
		driver.close();
	}
	}
