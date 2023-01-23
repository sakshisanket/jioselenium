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

public class jio_shop extends driverclass{

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
	
	  String url=driver.getCurrentUrl();
	  Assert.assertEquals(url , "https://www.jio.com/shop/homepage");
	  
	}
	
	@Test(priority=3)
	public static void smartphone() throws Exception
	{
		
		jio_shop.shop();
		
		commonmethod.clickable("//a[text()=\"Smartphone\"]");
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/shop/en-in/c/smartphones");
	}
	@Test(priority=4)
	public static void filter() throws Exception {
		
		jio_shop.smartphone();
		commonmethod.clickable("//div[@class=\"filter-container\"]/span");
		boolean popup=driver.findElement(By.xpath("//div[@class=\"modal-content\"]")).isDisplayed();
		Assert.assertTrue(popup);
	}
	@Test(priority=5)
	public static void button() throws Exception
	{
		jio_shop.filter();
		commonmethod.clickable("(//label[@class=\"checkbox-container\"])[1]");
		
		boolean popup=driver.findElement(By.xpath("//div[@class=\"modal-content\"]")).isDisplayed();
		Assert.assertTrue(popup);
	}
	
	@Test(priority=6)
	public static void apply() throws Exception
	{
		
		jio_shop.button();
		commonmethod.clickable("//button[@class=\"btn btn-primary\"]");
	
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/shop/en-in/c/smartphones?q=%3Arelevance%3Abrand%3AApple&text=");
	}
	@Test(priority=7)
	public static void selectanyproduct() throws Exception
	{
		jio_shop.apply();
		commonmethod.clickable("//img[@id=\"493177749\"]");
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/shop/en-in/apple-iphone-14/p/493177749");
		
	}
	
	@Test(priority=8)
	public static void viewdetails() throws Exception
	{
		jio_shop.selectanyproduct();
		commonmethod.clickable("//span[text()=\"View details\"]");
		
		boolean popup=driver.findElement(By.xpath("//div[@class=\"modal-body\"]")).isDisplayed();
		Assert.assertTrue(popup);
	}
	
	@Test(priority=9)
	public static void closebutton() throws Exception {
		jio_shop.viewdetails();
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
