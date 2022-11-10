package seleniumFrameworkDesign.PageObjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);    //this PageFactory will trigger the defined @FindBy		
	}
	
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css = ".mb-3")
	List<WebElement> listOfProducts;
	
	
	By products = By.cssSelector(".mb-3");
	By productSelected = By.cssSelector("b");
	By addToCartbtn = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	By animation = By.cssSelector(".ng-animating");
	
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(products);
		return listOfProducts;
	}
	
	
	public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream().filter(product->
		product.findElement(productSelected).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addToCart(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCartbtn).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(animation);
		
	}
	
	
}
