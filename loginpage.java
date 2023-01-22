package TestNgcommonmethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginpage extends driverclass {
	//public static WebDriver driver;
	@BeforeMethod
	public void setup() {
		driverclass.InstanceCreator("Chrome");
		driver.manage().window().maximize();
		driver.get("https://www.jio.com/");
	}
	
	@Test(priority=0)
	public void jiotitle()
	{
		String expectedtitle="Jio - Best Prepaid, Postpaid Plans, WiFi Connection & Mobile Apps";
		String actualtitle=driver.getTitle();
	    Assert.assertEquals(actualtitle, expectedtitle);
		
	}
	@Test(priority=1)
	public void urltest()
	{
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url,"https://www.jio.com/" );
	}
	@Test
	public static void logintab() throws InterruptedException
	{
		commonmethod.clickable("//a[@id=\"Sign-In\"]");
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/selfcare/login/");
	}
	@Test(priority=3)
	public static void mobile() throws InterruptedException
	{
		loginpage.logintab();;
		commonmethod.isDisplayed("//span[@class=\"j-selectors__item\"]");
		commonmethod.clickable("//input[@id=\"inputField\"]");
		commonmethod.sendkeys("//input[@id=\"inputField\"]","8888888888");
		commonmethod.clickable("//button[@class=\"j-button j-button-size__medium primary\"]");
	    boolean error= commonmethod.isDisplayed("//button[@class=\"j-button j-button-size__medium primary\"]");
	    Assert.assertTrue(error);
	}
	@Test(priority=4)
	public static void mobilesearch() throws InterruptedException
	{
		loginpage.logintab();;
		commonmethod.clickable("//input[@id=\"inputField\"]");
		commonmethod.sendkeys("//input[@id=\"inputField\"]","7676679890");
		boolean Button=commonmethod.isDisplayed("//button[@class=\"j-button j-button-size__medium primary\"]");
		Assert.assertTrue(Button);
	}
	@Test(priority=5)
	public static void search() throws InterruptedException
	{
		loginpage.logintab();;
		commonmethod.isDisplayed("//span[@class=\"j-selectors__item\"]");
		commonmethod.clickable("//input[@id=\"inputField\"]");
		boolean search=commonmethod.isEnabled("//input[@id=\"inputField\"]");
		Assert.assertTrue(search);
	}
	@Test(priority=6)
	public static void otherlogin() throws InterruptedException
	{
		loginpage.logintab();
		commonmethod.clickable("//section[@class=\"SignInMainContainer_moreLoginOption__1h_qk j-container\"]");
		boolean text=commonmethod.isDisplayed("//section[@class=\"SignInMainContainer_moreLoginOption__1h_qk j-container\"]");
		Assert.assertTrue(text);
	}
	@Test(priority=7)
	public void googlestore() throws InterruptedException
	{
		loginpage.logintab();
		commonmethod.scroll(driver, "//div[@class=\"stores\"]");
		Boolean option=commonmethod.isSelected("//div[@class=\"stores\"]");
		Thread.sleep(2000);
		Assert.assertFalse(option);
	}
	
	@Test(priority=8)
	public static void appstore() throws IOException, InterruptedException
	{
		loginpage.logintab();;
		commonmethod.clickable("//a[@class=\"j-link store\"][1]");
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url,"https://play.google.com/store/apps/details?id=com.jio.myjio");
	}
	
	@Test(priority=9)
	public static void applestore() throws InterruptedException
	{
		loginpage.logintab();
		commonmethod.clickable("//div[@class=\"j-header__grid\"]");
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/jcms/apps/");
	}
	
@AfterMethod
public void close() {
	driver.quit();
}
}


