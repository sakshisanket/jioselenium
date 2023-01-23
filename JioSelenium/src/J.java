package TestNG.copy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Trial1 {
	
	WebDriver driver;
	
	@BeforeTest
	public void WDInstance()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Nihit Sir\\Selenium\\Drivers\\Chrome Driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.jio.com/mobile");
	}
	
	@Test
	public void URL() throws InterruptedException
	{
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.jio.com/mobile");
		System.out.println(URL);
				
	}
	
	@Test
	public void JioFiberButton()
	{
		driver.findElement(By.xpath("//a[@aria-label=\"JioFiber\"]")).click();
		boolean JFTab = driver.findElement(By.xpath("//a[@aria-label=\"JioFiber\"]")).isDisplayed();
		Assert.assertTrue(JFTab);
	}
	
	@Test
	public void GetJioFiberButton()
	{
		driver.findElement(By.xpath("//a[@aria-label=\"JioFiber\"]")).click();
		driver.findElement(By.xpath("//a[@aria-label=\"Get JioFiber\"]")).click();
		boolean GJFTab = driver.findElement(By.xpath("//a[@aria-label=\\\"Get JioFiber\\\"]")).isDisplayed();
		Assert.assertTrue(GJFTab);
	}
	
	@Test
	public void BookJioFiber() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@aria-label=\"JioFiber\"]")).click();
		driver.findElement(By.xpath("//a[@aria-label=\"Get JioFiber\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("submitNumber")).sendKeys("Mithilesh");
		driver.findElement(By.id("submitMobile")).sendKeys("9976928392");
		driver.findElement(By.xpath("//div[@class=\"submitNumber_mobButton__3j8NS\"]")).click();
		boolean GOTP = driver.findElement(By.xpath("//div[@class=\"submitNumber_mobButton__3j8NS\"]")).isDisplayed();
		Assert.assertTrue(GOTP);
	}
	
	@Test
	public void Postpaid() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@aria-label=\"JioFiber\"]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//a[@aria-controls=\"jio-postpaid\"]")));
		Boolean Scroll = driver.findElement(By.xpath("//a[@aria-controls=\\\"jio-postpaid\\\"]")).isDisplayed();
		Assert.assertTrue(Scroll);
		
	}
	
	@Test
	public void Prepaid() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@aria-label=\"JioFiber\"]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//a[@aria-controls=\"jio-prepaid\"]")));
		driver.findElement(By.xpath("//a[@aria-controls=\"jio-prepaid\"]")).click();
		boolean Prep = driver.findElement(By.xpath("//a[@aria-controls=\\\"jio-prepaid\\\"]")).isDisplayed();
		Assert.assertTrue(Prep);
		
	}
	
	@Test
	public void PrepaidMenu() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@aria-label=\"JioFiber\"]")).click();
		driver.findElement(By.xpath("//nav[@parent-attr=\"JioFiber\"]/ul/li[2]/section/a[text()=\"Prepaid\"]")).click();
		boolean Post = driver.findElement(By.xpath("//nav[@parent-attr=\\\"JioFiber\\\"]/ul/li[2]/section/a[text()=\\\"Prepaid\\\"]")).isDisplayed();
		Assert.assertTrue(Post);
	}
	
	@Test
	public void PostpaidMenu() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@aria-label=\"JioFiber\"]")).click();
		driver.findElement(By.xpath("//nav[@parent-attr=\"JioFiber\"]/ul/li[3]/section/a[text()=\"Postpaid\"]")).click();
		boolean PostM = driver.findElement(By.xpath("//nav[@parent-attr=\\\"JioFiber\\\"]/ul/li[3]/section/a[text()=\\\"Postpaid\\\"]")).isDisplayed();
		Assert.assertTrue(PostM);	
	}
	
	@Test
	public void PostpaidMonthly() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@aria-label=\"JioFiber\"]")).click();
		driver.findElement(By.xpath("//nav[@parent-attr=\"JioFiber\"]/ul/li[3]/section/a[text()=\"Postpaid\"]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//button[@aria-label=\"button Monthly\"]")));
		driver.findElement(By.xpath("//button[@aria-label=\"button Monthly\"]")).click();
		boolean PostMon = driver.findElement(By.xpath("//button[@aria-label=\\\"button Monthly\\\"]")).isDisplayed();
		Assert.assertTrue(PostMon);
	}
	
	@Test
	public void PostpaidDataSchet() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@aria-label=\"JioFiber\"]")).click();
		driver.findElement(By.xpath("//nav[@parent-attr=\"JioFiber\"]/ul/li[3]/section/a[text()=\"Postpaid\"]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//button[@aria-label=\"button Data Sachet\"]")));
		driver.findElement(By.xpath("//button[@aria-label=\"button Data Sachet\"]")).click();
		boolean PostData = driver.findElement(By.xpath("//button[@aria-label=\\\"button Data Sachet\\\"]")).isDisplayed();
		Assert.assertTrue(PostData);
	}
	
	@AfterTest	
	public void Close()
	{
		driver.quit();
	}
	
	
	

}
