package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	//we need to keep variables as private and accessor methods as public inorder to acheive encapsulation
	
	private By cookies=By.id("onetrust-accept-btn-handler");
	private By login=By.cssSelector(".dropdown-toggle.disabled");
	private By text=By.xpath("//h2[@id='the-sales-hub-by-salesforce']/span");
	private By nav=By.cssSelector("ul[class*=main-nav]");
    private By logo=By.cssSelector("img[src*='logo-salesforce']");

	public WebElement acceptCookie() {
		
		return driver.findElement(cookies);
	}
	
	public LoginPage getLogin() {
		
		 driver.findElement(login).click();
		 LoginPage lp=new LoginPage(driver);
		 return lp;
		 //or we can write 'return new LoginPage(driver);'
		 
	}
    public WebElement getHeader() {
		
		return driver.findElement(text);
	}
    public WebElement getNav() {
		
		return driver.findElement(nav);
	}
    public WebElement getLogo() {
		
  		return driver.findElement(logo);
  	}
}
