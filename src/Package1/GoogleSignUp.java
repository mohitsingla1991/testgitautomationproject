package Package1;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class GoogleSignUp {

	public static void main(String[] args) throws InterruptedException {
		
		
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotifications.enabled", false);
		
		WebDriver driver = new FirefoxDriver(ffprofile);
		driver.manage().window().maximize();
		driver.get("https://consumerqa.canvera.com/products/");
		
	//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String pop_xpath = "//div[@class='col-md-7 right-block']";
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(pop_xpath)));
		Reporter.log("AutoPopup Appeared",true);
		//driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
		//Thread.sleep(10000);
		//driver.findElement(By.xpath("//button[@class='close']")).click();
		//Reporter.log("AutoPopup Closed",true);
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block google-btn']")).click();
		Reporter.log("clicked on Google SignUp",true);
		
		//Thread.sleep(5000);
		
		String parentWindow = driver.getWindowHandle();
		Set <String> handles =  driver.getWindowHandles();
		   for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		          driver.switchTo().window(windowHandle);
		     //    <!--Perform your operation here for new window-->
		          Thread.sleep(4000);
		         driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("mohit.singla@quovantis.com");
		         Thread.sleep(4000);
		         driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		     	 Thread.sleep(5000);
		   		 driver.findElement(By.xpath("//input[@type='password']")).sendKeys("msingla@306");
		     	 driver.findElement(By.xpath("//*[@id='passwordNext']/content/span")).click();
		     	 Reporter.log("I am on Logged In",true);
		        // driver.close(); //closing child window
		         driver.switchTo().window(parentWindow); //Control to parent window
		         Reporter.log("I am on Home Page",true);
		          }
		       }
		
	}
}
