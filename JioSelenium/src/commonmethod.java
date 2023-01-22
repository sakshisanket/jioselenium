import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;

public class commonmethod extends driverclass
{
	public static void clickable(String xpath) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).click();
  	}
	public static void scroll(WebDriver driver, String xpath)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(xpath)));
	}
	public static void sendkeys(String xpath, String key)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).sendKeys(key);;
	}
	public static boolean isDisplayed(String xpath)
	{
		return driver.findElement(By.xpath(xpath)).isDisplayed();
	}
	public static boolean isEnabled(String xpath)
	{
		return driver.findElement(By.xpath(xpath)).isEnabled();
	}
	public static boolean isSelected(String xpath)
	{
		return driver.findElement(By.xpath(xpath)).isSelected();
	}
	public static void screenshot( WebDriver driver ,String screenshotname, String path) throws IOException 
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File filename =new File(path+screenshotname+".png");
		if(filename.exists())
		{
			System.out.println("Screenshot exists");
			filename.delete();
			System.out.println("old[" +filename+ "]deleted");
			Files.copy(source, new File(path+screenshotname+".png"));
			System.out.println("[" + filename + "]copied in directory");
		}
		else 
		{
			System.out.println("Screenshot does not exists");
			Files.copy(source, new File(path+screenshotname+".png"));
			System.out.println("[" + filename + "]copied in directory path");
		}
	}
}

