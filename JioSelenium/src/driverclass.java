import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverclass 
{
	public static WebDriver driver;
	public static void InstanceCreator(String browser)
	{
		switch (browser) 
		{
		case "Chrome" :
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\NAMO\\Desktop\\MSSquareGlobal\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "Firefox" :
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\NAMO\\Desktop\\MSSquareGlobal\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			break;
		case "Edge" :
			System.setProperty("webdriver.msedge.driver", "C:\\Users\\NAMO\\Desktop\\MSSquareGlobal\\Drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
			break;
		default:
			System.out.println(browser+" is not available.Please select browser among Chrome, Firefox, Edge");
			break;
		}
	}
}
