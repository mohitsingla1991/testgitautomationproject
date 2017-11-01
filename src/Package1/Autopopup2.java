package Package1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Autopopup2 {

	public static void main(String[] args) throws InterruptedException {
		
		
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotifications.enabled", false);
		
		WebDriver driver = new FirefoxDriver(ffprofile);
		driver.manage().window().maximize();
		driver.get("https://canvera.com/products/");
		String winHandleBefore = driver.getWindowHandle();
		
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		String pop_xpath = "//div[@class='col-md-7 right-block']";
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(pop_xpath)));
//		Reporter.log("AutoPopup Appeared",true);
		//driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
		//Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class='close']")).click();
		Reporter.log("AutoPopup Closed",true);
		
		System.out.println("inside verifyAvtarIcon");
		  
		  Actions action = new Actions(driver);
		  WebElement avtarLink = driver.findElement(By.xpath(".//li[@id='user-dropdown']//a//i"));
		  WebElement avtarSignInLink = driver.findElement(By.xpath(".//*[@id='user-dropdown']/div/ul//li//a[text()='Sign In']"));
				  action.moveToElement(avtarLink).perform();
				  action.moveToElement(avtarLink).click(avtarSignInLink).build().perform();

				  String expRes = "Sign in to Canvera";
					
					 String actRes = driver.findElement(By.xpath("html/body/my-app/sign-in/section/div/h2")).getText();
					 Reporter.log(actRes, true);
					 Assert.assertEquals(actRes, expRes, "SignIn link Not Present on Home page");
					 Reporter.log("SignIN Link present on Home page, hence script is PASS", true); 
//		driver.findElement(By.xpath(".//div[@class='col-md-6 col-sm-6 hidden-xs']//div[@class='col-md-6 col-sm-6']//ul[@class='list-unstyled']//li//a[text()='About Canvera']")).click();
//		Reporter.log("About Cavera clicked",true);
//	
//		//waitForNewWindowAndSwitchToIt(driver); 
//		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.ALT + "Tab");
//		//driver.switchTo().Window(driver.windowHandle.Last());
//		
//		for(String winHandle : driver.getWindowHandles()){
//		    driver.switchTo().window(winHandle);
//		}
//		
//		String expRes = "About Us | Meet Our Leaders";
//			 String actRes = driver.getTitle();
//			 Reporter.log(actRes, true);
//			 
//			 Assert.assertEquals(actRes, expRes, "About Canvera Present on Home page");
//			 Reporter.log("About Canvera present on Home page, hence script is PASS", true);
//		  
		
		 
//		  String canveraFooterLink = "//canvera-footer//p";
//		System.out.println("inside verifyCanverafooterLink");
//		 
//		  
//		  
//		String expRes = "© 2017 Canvera. All rights reserved.";
//		
//			  String actRes = driver.findElement(By.xpath(canveraFooterLink)).getText();
//			 Reporter.log(actRes, true);
//			 
//			 Assert.assertEquals(actRes, expRes, "Footer text Not Present on Home page");
//			 Reporter.log("Footer text present on Home page, hence script is PASS", true); 
	}
}
