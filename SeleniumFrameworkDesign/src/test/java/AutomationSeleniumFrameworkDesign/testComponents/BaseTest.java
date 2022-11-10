package AutomationSeleniumFrameworkDesign.testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumFrameworkDesign.PageObjects.LandingPage;

public class BaseTest {
	 public WebDriver driver;
	 public String url = "https://rahulshettyacademy.com/client";
	 public LandingPage lp;
	 
	
	public WebDriver initializeTest() throws IOException {
		
		
		
		
		Properties prop = new Properties();   //prop object will help to access the global data files
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + 
				"//src//main//java//seleniumFramewrokDesign//resources//GlobalData.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		
		
		
		if(browser.equals("Chrome")) {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

		}
		
		else if(browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
		}
			
			
		else  if(browser.equals("Safari")){
			WebDriverManager.safaridriver().setup();
	        driver = new SafariDriver();

			}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
			
		}
	
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		
		driver = initializeTest();
		lp = new LandingPage(driver);
		lp.getLandingPage(url);
		return lp;
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		driver.quit();
	}
	}

