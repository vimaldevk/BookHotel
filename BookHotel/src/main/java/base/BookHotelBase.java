package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BookHotelBase {
	public static Properties prop;
	public static WebDriver driver;
	public BookHotelBase() {
		prop= new Properties();
		try {
			FileInputStream fin= new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//config//config.properties");
			prop.load(fin);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialize() {
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
		//	System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\webdriver\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\ChromeDriver\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\GeckoDriver\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(System.getProperty("user.dir")+prop.getProperty("url"));
	}
}
