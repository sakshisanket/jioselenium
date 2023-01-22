package testnf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testcases extends driverclass{

	//public static WebDriver driver;

	@BeforeMethod
   public void setup() {
	driverclass.InstanceCreator("Chrome");
	      
	    driver.get("https://www.jio.com/");
	      driver.manage().window().maximize();
   }
	@Test(priority=1)
	public void urltest() {
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/");
	}
	
	@Test(priority=2)
	public static void shop(){
		
		commonmethod.clickable("//a[@aria-label=\"Shop\"]");
	//  driver.findElement(By.xpath("//a[@aria-label=\"Shop\"]")).click();
	  String url=driver.getCurrentUrl();
	  Assert.assertEquals(url , "https://www.jio.com/shop/homepage");
	  
	}
	
	@Test(priority=3)
	public static void smartphone() throws Exception
	{
		
		testcases.shop();
		
		commonmethod.clickable("//a[text()=\"Smartphone\"]");

		//driver.findElement(By.xpath("")).click();
		Thread.sleep(5000);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/shop/en-in/c/smartphones");
	}
	@Test(priority=4)
	public static void filter() throws Exception {
		
		testcases.smartphone();
		commonmethod.clickable("//div[@class=\"filter-container\"]/span");
		//driver.findElement(By.xpath("//div[@class=\"filter-container\"]/span")).click();
		Thread.sleep(4000);
		boolean popup=driver.findElement(By.xpath("//div[@class=\"modal-content\"]")).isDisplayed();
		Assert.assertTrue(popup);
	}
	@Test(priority=5)
	public static void button() throws Exception
	{
		testcases.filter();
		commonmethod.clickable("(//label[@class=\"checkbox-container\"])[1]");
		//driver.findElement(By.xpath("//label[@class=\"checkbox-container\"]/span")).click();
		//Thread.sleep(2000);
		boolean popup=driver.findElement(By.xpath("//div[@class=\"modal-content\"]")).isDisplayed();
		Assert.assertTrue(popup);
	}
	
	@Test(priority=6)
	public static void apply() throws Exception
	{
		
		testcases.button();
		commonmethod.clickable("//button[@class=\"btn btn-primary\"]");
		//driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
		//Thread.sleep(2000);
		
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/shop/en-in/c/smartphones?q=%3Arelevance%3Abrand%3AApple&text=");
	}
	@Test(priority=7)
	public static void selectanyproduct() throws Exception
	{
		testcases.apply();
		commonmethod.clickable("//img[@id=\"493177749\"]");
		//driver.findElement(By.xpath("//img[@id=\"493177749\"]")).click();

		
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/shop/en-in/apple-iphone-14/p/493177749");
		
	}
	
	@Test(priority=8)
	public static void viewdetails() throws Exception
	{
		testcases.selectanyproduct();
		commonmethod.clickable("//span[text()=\"View details\"]");
		//driver.findElement(By.xpath("//span[text()=\"View details\"]")).click();
		Thread.sleep(2000);
		
		boolean popup=driver.findElement(By.xpath("//div[@class=\"modal-body\"]")).isDisplayed();
		Assert.assertTrue(popup);
	}
	
	@Test(priority=9)
	public static void closebutton() throws Exception {
		testcases.viewdetails();
		commonmethod.clickable("(//button[@class=\"close\"])[1]");
		
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/shop/en-in/apple-iphone-14/p/493177749");
		
	}
	
	@AfterMethod()
	public void close()
	{
		driver.quit();
	}
}
