package Package1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Homepage {

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
		driver.findElement(By.xpath("//button[@class='close']")).click();
		Reporter.log("AutoPopup Closed",true);
	Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//a[@class='navbar-brand active']/img[@class='img-responsive']")),"Canvera Logo");
	}
}
