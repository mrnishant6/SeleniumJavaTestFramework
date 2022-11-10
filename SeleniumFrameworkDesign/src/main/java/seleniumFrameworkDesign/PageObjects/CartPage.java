package seleniumFrameworkDesign.PageObjects;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class CartPage  extends AbstractComponent{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);    //this PageFactory will trigger the defined @FindBy		
	}
	
	
	
	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartSection;
	
	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	private WebElement checkoutbtn;
	
	
	
	
	public  boolean verifyProductInCart(String productName) {
		Boolean match = cartSection.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckout() {
		checkoutbtn.click();
		CheckoutPage checkout = new CheckoutPage(driver);
		return checkout;
	}
	
	

}
