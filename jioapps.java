package commonmethod;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class jioapps extends driverclass
{
	//public static WebDriver driver;
	@BeforeMethod
	public void comman()
	{
		driverclass.InstanceCreator("Edge");
		driver.manage().window().maximize();
		driver.get("https://www.jio.com/");
	}
	@Test(priority=1)
	public void urltest()
	{
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/");
	}
	@Test(priority=2)
	public static void apps() throws InterruptedException
	{
		//driver.findElement(By.xpath("//a[@aria-label=\"Apps\"]")).click();
		commonmethod.clickable("//a[@aria-label=\"Apps\"]");
		Thread.sleep(2000);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/jcms/apps/");
	}
	@Test(priority=3)
	public static void myjio() throws InterruptedException
	{
        jioapps.apps();
	    commonmethod.isDisplayed("(//h6[@class=\"j-heading j-text-heading-xxs\"])[1]");
		boolean myjio=commonmethod.isDisplayed("(//h6[@class=\"j-heading j-text-heading-xxs\"])[1]");
        Assert.assertTrue(myjio);
	}
	@Test(priority=4)
	public static void myjiogetnow() throws InterruptedException
	{
		jioapps.apps();
		commonmethod.clickable("//h6[text()=\"MyJio\"]/../../../../../../../../../../../div[2]/div/div/button[@aria-label=\"Get Now\"]");
		boolean popup=commonmethod.isDisplayed("//div[@class=\"j-modal-content\"]");
		Assert.assertTrue(popup);
	}
	@Test(priority=5)
	public void ongoogleplay() throws InterruptedException
	{
		jioapps.myjiogetnow();
		commonmethod.clickable("//div[@aria-label=\"playstore-link\"]");
		Thread.sleep(2000);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://play.google.com/store/apps/details?id=com.jio.myjio");
		
	}
	@Test(priority=6)
	public void knowmore() throws InterruptedException
	{
		jioapps.apps();
		commonmethod.clickable("//h6[text()=\"MyJio\"]/../../../../../../../../../../../div[2]/div/div/button[@aria-label=\"Know more\"]");
		Thread.sleep(2000);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/jcms/apps/myjio/");
	}
	@Test(priority=7)
	public static void jiosaavngetnow() throws InterruptedException
	{
		jioapps.apps();
		commonmethod.clickable("//h6[text()=\"JioSaavn\"]/../../../../../../../../../../../div[2]/div/div/button[@aria-label=\"Get Now\"]");
		boolean popup=commonmethod.isDisplayed("//div[@class=\"j-modal-content\"]");
		Assert.assertTrue(popup);
	}
	@Test(priority=8)
	public void jiosaavncheckitout() throws InterruptedException
	{
		jioapps.apps();
		commonmethod.clickable("//h6[text()=\"JioSaavn\"]/../../../../../../../../../../../div[2]/div/div/button[@aria-label=\"Check it out\"]");
		Thread.sleep(2000);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/jcms/apps/jiosaavn/");
	}
	@Test(priority=9)
	public static void jiotvgetnow() throws InterruptedException
	{
		jioapps.apps();
		commonmethod.clickable("//h6[text()=\"JioTV\"]/../../../../../../../../../../../div[2]/div/div/button[@aria-label=\"Get Now\"]");
		boolean popup=commonmethod.isDisplayed("//div[@class=\"j-modal-content\"]");
		Assert.assertTrue(popup);
	}
	@Test(priority=10)
	public void jiotvlearnmore() throws InterruptedException
	{
		jioapps.apps();
		commonmethod.clickable("//h6[text()=\"JioTV\"]/../../../../../../../../../../../div[2]/div/div/button[@aria-label=\"Learn more\"]");
		Thread.sleep(2000);
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/jcms/apps/jiotv/");
	}
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}