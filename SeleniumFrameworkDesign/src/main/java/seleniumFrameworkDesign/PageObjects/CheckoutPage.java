package seleniumFrameworkDesign.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	
	WebDriver driver;
	

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//*[contains(text(),'CVV')]/following-sibling::input")
	WebElement cvv;
	
	
	@FindBy(css = "[placeholder *= 'Country']")
	WebElement country;
	
	
	@FindBy(css = ".action__submit")
	WebElement placeOrderbtn;
	
	
	By resultCountries = By.cssSelector(".ta-results");
	
	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement selectCountry;
	
	
	@FindBy(css = ".hero-primary")
	WebElement thankYouMsg;
	
	
	
	public void enterCvv() {
		cvv.sendKeys("087");
	}
	
	public void selectIndiaFromDropdown(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(resultCountries);
		selectCountry.click();

	}
	
	
	public ConfirmationPage placeOrder() {
		placeOrderbtn.click();
		ConfirmationPage confirm = new ConfirmationPage(driver);
		return confirm;
	}
	
	

}
