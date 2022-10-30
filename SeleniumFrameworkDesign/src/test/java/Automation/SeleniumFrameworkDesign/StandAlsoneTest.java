package Automation.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlsoneTest {

	public static void main(String[] args) {
		
		
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("nishant26964@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("@2Nishant3353");
		driver.findElement(By.id("login")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".mb-3"))));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#toast-container"))));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
	    List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	   Boolean match =cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
	   System.out.print(match);
	   Assert.assertTrue(match);
	   
	   driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
	   
	   driver.findElement(By.xpath("//*[contains(text(),'CVV')]/following-sibling::input")).sendKeys("098");
	   
	   
	   
	   Actions a = new Actions(driver);
	   a.sendKeys(driver.findElement(By.cssSelector("[placeholder *= 'Country']")), "India").build().perform();
	   
	   wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
	   
	   driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	   
	   driver.findElement(By.cssSelector(".action__submit")).click();
	   
	   String Confirmed = driver.findElement(By.cssSelector(".hero-primary")).getText();
	   
	   Assert.assertTrue(Confirmed.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	   
	   driver.close();
	   driver.quit();
	   
	   
	   
	   
	   
	   
	   
	   
		   
	   }
	   
	   
	   
	   
	   
		







	}

