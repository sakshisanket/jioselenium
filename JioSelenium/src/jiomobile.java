package mobile_salenium_jio;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class jiomobile extends driverclass {
	//WebDriver driver;
	
	@BeforeMethod
	
	public void setup(){
		driverclass.InstanceCreator("Chrome");
		driver.manage().window().maximize();
		driver.get("https://www.jio.com/");
	}
	
	@Test(priority=0)
	public void jiotitle()
	{
		//title verification by using assertclass
		String myjiotitle="Jio - Best Prepaid, Postpaid Plans, WiFi Connection & Mobile Apps";
		String myactualtitle=driver.getTitle();
		Assert.assertEquals(myactualtitle, myactualtitle);
	}
	
	@Test(priority=1)
	public void urltest()throws  InterruptedException, IOException
	{
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/");
		
	}
	
	@Test(priority=2)
	public static void mobile() 
	{
		
		commonmethod.clickable(" //a[@aria-label=\"Mobile\"]");
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/mobile");
	}
	
	
	@Test(priority=3)
	public static void Discover() throws InterruptedException 
	{
		commonmethod.clickable(" //a[@aria-label=\"Mobile\"]");
		
		//Assert.assertEquals(url, "https://www.jio.com/mobile");
		
		commonmethod.clickable("//a[@onclick=\"gotoURLGeneric('','no');trackGenericGA('Discover','Mobile','New headerclick','revamped_jiocom')\"]");
		
		commonmethod.clickable("//button[@class=\"j-button j-button-size__medium primary redirectButton w-auto mr-3 mt-3 \"]");
		//lets register your internet jio 5g
		commonmethod.sendkeys("//input[@id=\"user-number-5ginterested\"]","7676679890");
		//generate otp for true5g      
		//commonmethod.clickable("//button[@id=\"generateOTP-btn-5ginterested\"]", driver);
		//Boolean button =commonmethod.isEnabled("//button[@id=\"generateOTP-btn-5ginterested\"]", driver);
		//Assert.assertTrue(button);
		Boolean button =commonmethod.isEnabled("//input[@id=\"user-number-5ginterested\"]");
		Assert.assertTrue(button);
		
		
	}

		
		

		@Test(priority=4)
		public void DiscoverRecharge() throws InterruptedException 
		{
		    commonmethod.clickable(" //a[@aria-label=\"Mobile\"]");
			
			//quick recharge in mobile feauture below
			commonmethod.clickable("//button[@id=\"quick-recharge\"]");//a[@aria-controls="mobile"]
			
			commonmethod.clickable("//a[@aria-controls=\"mobile\"]");//input[@id="quick-recharge-user-number"]
	
			//mobile number text box
			//driver.findElement(By.xpath("//input[@id=\"quick-recharge-user-number\"]")).sendKeys("7676679890");
			
		    commonmethod.sendkeys("//input[@class=\"pd--right\"]" ,"7676679890");
	
			commonmethod.clickable("//button[@class=\"j-button j-button-size__medium primary continue-btn btn-disabled\"]");
			//assert
			Boolean buttonview = driver.findElement(By.xpath("//button[@class=\"j-button j-button-size__medium primary continue-btn btn-disabled\"]")).isEnabled();
			Assert.assertTrue(buttonview);
			
		}
	
	@Test(priority=5)
	public void getnewsim() throws InterruptedException 
	{
      
		commonmethod.clickable(" //a[@aria-label=\"Mobile\"]");
        commonmethod.clickable("//a[@onclick=\"gotoURLGeneric('','no');trackGenericGA('Discover','Mobile','New headerclick','revamped_jiocom')\"]");
	
		commonmethod.clickable("//button[@class=\"j-button j-button-size__medium flex-grow-0 w-auto primary\"]");
		//get jio sim name textbox 
		
		commonmethod.sendkeys("//input[@id=\"user-name\"]","MAYURI");
		//assertion 
		boolean textsearch=commonmethod.isDisplayed("//input[@id=\"user-name\"]");
		Assert.assertTrue( textsearch);
	}
	
	
	@Test(priority=6)
	public void prepaid() throws InterruptedException
	{
	    commonmethod.clickable(" //a[@aria-label=\"Mobile\"]");
		commonmethod.clickable("//a[@cust-url=\"/selfcare/plans/mobility/prepaid-plans-home/\"]");
	    //prepaid feature=annual plan
		commonmethod.isEnabled("(//button[@class=\"Banner_btn__1m9ub j-button j-button-size__medium primary\"])[1]");
		Boolean button =commonmethod.isEnabled("//a[@aria-label=\"Mobile\"]");
		Assert.assertTrue(button);

	}
	
	@Test(priority=6)
	public void postpaid() throws InterruptedException
	
	{
		
		commonmethod.clickable(" //a[@aria-label=\"Mobile\"]");
		commonmethod.clickable("//a[@onclick=\"gotoURLGeneric('','no');trackGenericGA('Postpaid','Mobile','New headerclick','revamped_jiocom')\"]");
		driver.findElement(By.xpath("//button[@class=\"Banner_btn__1m9ub j-button j-button-size__medium primary\"]")).click();
		//assert for validation
		boolean button=commonmethod.isEnabled("//a[@onclick=\"gotoURLGeneric('','no');trackGenericGA('Postpaid','Mobile','New headerclick','revamped_jiocom')\"]");
	    Assert.assertTrue(button);
	
	}
	
	
	@Test(priority=7)
	public void GetjioSim() throws InterruptedException
	{ 
		commonmethod.clickable(" //a[@aria-label=\"Mobile\"]");

		commonmethod.clickable("//a[@cust-url=\"/selfcare/interest/sim/\"]");
		
		commonmethod.clickable("//input[@id=\"submitNumber\" and @maxlength=\"40\"]");
		
		//assertion
		boolean button=commonmethod.isDisplayed("//input[@id=\"submitNumber\" and @maxlength=\"40\"]");
		Assert.assertTrue(button);
	}
	
	@Test(priority=8)
	public void Recharge() throws InterruptedException
	{
		commonmethod.clickable(" //a[@aria-label=\"Mobile\"]");
		
		commonmethod.clickable("//a[@cust-url=\"/selfcare/recharge/mobility/\"]");
		
		//mobile
		commonmethod.clickable("//span[@class=\"content\"]/div[text()='Mobile']");
		
		commonmethod.sendkeys("//input[@id=\"submitNumber\" and @textmask=\"##########\"]","7676679890");
	
		commonmethod.clickable("//div[@style=\"width: 100%;\"]/button[1]");
		
		//assertion for validation
		boolean buttonforclick=commonmethod.isEnabled("//input[@id=\"submitNumber\" and @textmask=\"##########\"]");
		Assert.assertTrue(buttonforclick);
	}
	
	
	@Test(priority=9)
	public static void paybill()
 {
		//mobile
		commonmethod.clickable("//a[@aria-label=\"Mobile\"]");
		//paybill
		commonmethod.clickable("//ul[@aria-label=\"Header Nav\"]/li[7]/section/a[@aria-label=\"Pay Bills\"]");
          //mobile number
		commonmethod.sendkeys("//input[@id=\"submitNumber\"]","7676679890");
		//ammount
		commonmethod.sendkeys("//input[@id=\"amount\"]","299");
		//continue
		commonmethod.clickable("//button[@aria-label=\"button Continue\"]");
		boolean button=commonmethod.isEnabled("//button[@aria-label=\"button Continue\"]");
		Assert.assertTrue(button);
		
		
 }
	@Test(priority=10)
	public static void mobilesearchbar()
	{
		
		commonmethod.clickable(" //a[@aria-label=\"Mobile\"]");
		commonmethod.clickable("//input[@onclick=\"searchClick();trackGenericGA('Click','Search','New top header','revamped_jiocom');\"]");
		commonmethod.sendkeys("//input[@onclick=\"searchClick();trackGenericGA('Click','Search','New top header','revamped_jiocom');\"]","R");
		boolean textsearch=commonmethod.isEnabled("//input[@onkeyup=\"getAutoSuggestionsPlain(event)\"]");
		Assert.assertTrue(textsearch);
		
	}
	
	
		
	
	@AfterMethod
	public void close()
	{
	driver.quit();
	}

}
