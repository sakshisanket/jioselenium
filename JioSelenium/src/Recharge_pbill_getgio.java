package test_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Recharge_pbill_getgio extends driverclass {
	//WebDriver driver;
	@BeforeMethod
	public  void setup() 
	{
		
		driverclass.InstanceCreator("Chrome");
		driver.manage().window().maximize();
		driver.get("https://www.jio.com/");
		
	}
	@Test(priority=1)
	public void LaunchURL() 
	{
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/");
	}
	@Test(priority=2)
	public static void RechargeButton() throws InterruptedException
	{
		commonmethod.clickable("//a[@id=\"quick-recharge\"]/div[@class=\"icon-size-64 j-icon j-icon__bg j-relative\"]");
		Thread.sleep(3000);
		boolean popup =commonmethod.isDisplayed("//div[@class=\"input-info-wrapper\"]");
		Assert.assertTrue(popup);
	}
	@Test(priority=3)
	public void AddJioNumber() throws InterruptedException 
	{
		commonmethod.clickable("//a[@id=\"quick-recharge\"]/div[@class=\"icon-size-64 j-icon j-icon__bg j-relative\"]");
		
		commonmethod.sendkeys("//input[@id=\"quick-recharge-user-number\"]","8010029771");
		Thread.sleep(3000);
		boolean button =commonmethod.isEnabled("//button[@class=\"j-button j-button-size__medium primary continue-btn btn-disabled\"]");
		Assert.assertTrue(button);
	}
	@Test(priority=4)
	public void clickcontinuebutt() throws InterruptedException
	{
		commonmethod.clickable("//a[@id=\"quick-recharge\"]/div[@class=\"icon-size-64 j-icon j-icon__bg j-relative\"]");
		
		commonmethod.sendkeys("//input[@id=\"quick-recharge-user-number\"]","8010029771");
		
		commonmethod.clickable("//button[@class=\"j-button j-button-size__medium primary continue-btn btn-disabled\"]");
		Thread.sleep(3000);
		boolean popup =commonmethod.isDisplayed("//div[@class=\"choose-plan-wrapper\"]");
		Assert.assertTrue(popup);
	}
	@Test(priority=5)
	public void clickcrossbutt() throws InterruptedException 
	{
        commonmethod.clickable("//a[@id=\"quick-recharge\"]/div[@class=\"icon-size-64 j-icon j-icon__bg j-relative\"]");
		
		commonmethod.sendkeys("//input[@id=\"quick-recharge-user-number\"]","8010029771");
		
		commonmethod.clickable("//button[@class=\"j-button j-button-size__medium primary continue-btn btn-disabled\"]");
		
		commonmethod.clickable("//div[@class=\"modal_overflow_slick j-modal j-modal-closable j-modal-size-s j-modal-kind-dialog quick-recharge-wrapper j-modal-visible\"]/div/header/button");
		Thread.sleep(3000);
	}
	@Test(priority=6)
	public void clickpaybill() throws InterruptedException 
	{
        commonmethod.clickable("//a[@id=\"quick-recharge\"]/div[@class=\"icon-size-64 j-icon j-icon__bg j-relative\"]");
		
		commonmethod.sendkeys("//input[@id=\"quick-recharge-user-number\"]","8010029771");
		
		commonmethod.clickable("//button[@class=\"j-button j-button-size__medium primary continue-btn btn-disabled\"]");
		
		commonmethod.clickable("//div[@class=\"modal_overflow_slick j-modal j-modal-closable j-modal-size-s j-modal-kind-dialog quick-recharge-wrapper j-modal-visible\"]/div/header/button");
		Thread.sleep(3000);
		commonmethod.clickable("//a[@id=\"paybill\"]/div[@class=\"icon-size-64 j-icon j-icon__bg j-relative\"]");
		Thread.sleep(3000);
		//boolean popup =driver.findElement(By.xpath("//div[@class=\"j-modal-body\"]")).isDisplayed();
		//Assert.assertTrue(popup);
		
	}
	@Test(priority=7)
	public void closepage() throws InterruptedException
	{	
		    commonmethod.clickable("//a[@id=\"quick-recharge\"]/div[@class=\"icon-size-64 j-icon j-icon__bg j-relative\"]");
			
			commonmethod.sendkeys("//input[@id=\"quick-recharge-user-number\"]","8010029771");
			
			commonmethod.clickable("//button[@class=\"j-button j-button-size__medium primary continue-btn btn-disabled\"]");
			
			commonmethod.clickable("//div[@class=\"modal_overflow_slick j-modal j-modal-closable j-modal-size-s j-modal-kind-dialog quick-recharge-wrapper j-modal-visible\"]/div/header/button");
			Thread.sleep(3000);
			commonmethod.clickable("//a[@id=\"paybill\"]/div[@class=\"icon-size-64 j-icon j-icon__bg j-relative\"]");
		   Thread.sleep(3000);
		    commonmethod.clickable("//button[@onclick=\"resetPBPopUp('close')\"]");
	}
	@Test(priority=8)
	public void Getjiosim() throws InterruptedException 
	{
		    commonmethod.clickable("//a[@id=\"quick-recharge\"]/div[@class=\"icon-size-64 j-icon j-icon__bg j-relative\"]");
			
			commonmethod.sendkeys("//input[@id=\"quick-recharge-user-number\"]","8010029771");
			
			commonmethod.clickable("//button[@class=\"j-button j-button-size__medium primary continue-btn btn-disabled\"]");
			
			commonmethod.clickable("//div[@class=\"modal_overflow_slick j-modal j-modal-closable j-modal-size-s j-modal-kind-dialog quick-recharge-wrapper j-modal-visible\"]/div/header/button");
			Thread.sleep(3000);
			commonmethod.clickable("//a[@id=\"paybill\"]/div[@class=\"icon-size-64 j-icon j-icon__bg j-relative\"]");
		   Thread.sleep(3000);
		    commonmethod.clickable("//button[@onclick=\"resetPBPopUp('close')\"]");
		    Thread.sleep(3000);
		    commonmethod.clickable("//a[@onclick=\"GAChipsDS('Get Jio SIM','Click')\"]");
		    Thread.sleep(3000);
		
	}
				
	
	@AfterMethod
	public void close()
	{
		driver.quit();

	}
}
