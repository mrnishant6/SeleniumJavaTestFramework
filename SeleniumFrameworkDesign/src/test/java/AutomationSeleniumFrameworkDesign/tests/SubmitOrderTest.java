package AutomationSeleniumFrameworkDesign.tests;

import java.io.IOException;
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
import org.testng.annotations.Test;

import AutomationSeleniumFrameworkDesign.testComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumFrameworkDesign.PageObjects.CartPage;
import seleniumFrameworkDesign.PageObjects.CheckoutPage;
import seleniumFrameworkDesign.PageObjects.ConfirmationPage;
import seleniumFrameworkDesign.PageObjects.LandingPage;
import seleniumFrameworkDesign.PageObjects.ProductCatalogue;

public class SubmitOrderTest  extends BaseTest{


        @Test
        
        public void submitOrder() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";
		String email  = "nishant26964@gmail.com";
		String pass = "@2Nishant3353";
		String country = "India";
		ProductCatalogue pc =lp.loginToApplication(email, pass);

		List <WebElement> products = pc.getProductList();
		pc.addToCart(productName);
		CartPage cp =  pc.goToCart();
		Boolean match = cp.verifyProductInCart(productName);


		System.out.print(match);
		Assert.assertTrue(match);

		CheckoutPage checkout = cp.goToCheckout();

		checkout.enterCvv();

		checkout.selectIndiaFromDropdown(country);

		ConfirmationPage confirmOrder = checkout.placeOrder();
		String Confirmed =confirmOrder.thankYouMsg();


		Assert.assertTrue(Confirmed.equalsIgnoreCase("THANKYOU FOR THE ORDER."));










	}
}













