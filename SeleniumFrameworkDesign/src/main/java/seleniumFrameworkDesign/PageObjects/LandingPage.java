package seleniumFrameworkDesign.PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class LandingPage  extends AbstractComponent{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);    //this PageFactory will trigger the defined @FindBy		
	}
	
	
	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy(id = "userPassword")
	WebElement userPass;
	
	
	@FindBy(id = "login")
	WebElement lgnbtn;
	
	
	public ProductCatalogue loginToApplication(String email, String pass) {
		userEmail.sendKeys(email);
		userPass.sendKeys(pass);
		lgnbtn.click();
		ProductCatalogue pc = new ProductCatalogue(driver);
		return pc;
		
	}
	
	
	
	public void getLandingPage(String url) {
		driver.get(url);
	}

}
