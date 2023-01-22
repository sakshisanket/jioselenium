import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class jioTrue5G extends driverclass
{
	//public static WebDriver driver;
	@BeforeMethod
	public void setup()
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
	public static void true5g()
	{
		commonmethod.clickable("//a[@aria-label=\"True 5G\"]");
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/5g");
	}
	@Test(priority=3)
	public static void device5GReady() throws InterruptedException 
	{
		jioTrue5G.true5g();
		commonmethod.clickable("//button[@data-id=\"checkcompatib\"]");
		Thread.sleep(2000);
		boolean popup=commonmethod.isDisplayed("//div[@id=\"generate-number-wrapper-id\"]");
		Assert.assertTrue(popup);
	}
	@Test(priority=4)
	public static void mobilenumber() throws InterruptedException
	{
		jioTrue5G.device5GReady();
		commonmethod.clickable("//input[@id=\"user-number-fiber-5g\"]");
		commonmethod.sendkeys("//input[@id=\"user-number-fiber-5g\"]", "80100");
		boolean button=commonmethod.isDisplayed("//button[@id=\"generateOTP-btn-fiber\"]");
		Assert.assertTrue(button);
	}
	@Test(priority=5)
	public static void negativegenerateotp() throws InterruptedException
	{
		jioTrue5G.mobilenumber();
		commonmethod.clickable("//button[@id=\"generateOTP-btn-fiber\"]");
		Thread.sleep(2000);
		boolean error=commonmethod.isDisplayed("//div[@id=\"user-number-invalid-fiber\"]");
		Assert.assertTrue(error);
	}
	@Test(priority=5)
	public static void positivegenerateotp() throws InterruptedException
	{
		jioTrue5G.mobilenumber();
		commonmethod.sendkeys("//input[@id=\"user-number-fiber-5g\"]", "8010029771");
		commonmethod.clickable("//button[@id=\"generateOTP-btn-fiber\"]");
		Thread.sleep(2000);
		boolean otp=commonmethod.isDisplayed("//div[@class=\"verify-number-wrapper  txt-align--left\"]");
		Assert.assertTrue(otp);
	}
	@Test(priority=6)
	public static void closebutton() throws InterruptedException
	{
		jioTrue5G.negativegenerateotp();
		commonmethod.clickable("//button[@data-popup-close=\"modal-checkcompatib\"]");
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.jio.com/5g");
	}
	@Test(priority=7)
	public static void statedropdown() throws InterruptedException
	{
		jioTrue5G.true5g();
		commonmethod.scroll(driver, "(//span[@class=\"select2-selection__arrow\"])[1]");
		commonmethod.clickable("(//span[@class=\"select2-selection__arrow\"])[1]");
		Thread.sleep(2000);
		boolean dropdown=commonmethod.isDisplayed("//span[@class=\"select2-dropdown select2-dropdown--below\"]");
		Assert.assertTrue(dropdown);
		}
	@Test(priority=8)
	public static void state() throws InterruptedException
	{
		jioTrue5G.statedropdown();
		commonmethod.sendkeys("//span[@class=\"select2-search select2-search--dropdown\"]/input", "Mahara");
		Thread.sleep(2000);
		boolean selection=commonmethod.isDisplayed("//span[@class=\"select2-results\"]/ul");
		Assert.assertTrue(selection);
		}
	@Test(priority=9)
	public static void selectstate() throws InterruptedException
	{
		jioTrue5G.state();
		commonmethod.clickable("//span[@class=\"select2-results\"]/ul/li");
		Thread.sleep(2000);
		boolean button=commonmethod.isDisplayed("//button[@id=\"iminterested-5g2\"]");
		Assert.assertTrue(button);
	}
	@Test(priority=10)
	public static void expressinternet() throws InterruptedException
	{
		jioTrue5G.selectstate();
		commonmethod.clickable("//button[@id=\"iminterested-5g2\"]");
		Thread.sleep(2000);
		boolean popup=commonmethod.isDisplayed("//div[@id=\"generate-number-wrapper-id-5ginterested\"]");
		Assert.assertTrue(popup);
	}
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
