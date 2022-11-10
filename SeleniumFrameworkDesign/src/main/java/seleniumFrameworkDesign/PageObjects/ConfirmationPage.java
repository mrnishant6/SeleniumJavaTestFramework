package seleniumFrameworkDesign.PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class ConfirmationPage  extends AbstractComponent{
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);    //this PageFactory will trigger the defined @FindBy		
	}
	
	
	
	@FindBy(css = ".hero-primary")
	WebElement thankMsg;
	
	public String thankYouMsg() {
		return thankMsg.getText();
	}
	


}
