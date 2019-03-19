package com.automationpractice.com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationpracticeMyStore.pageObjects.Cart;
import com.automationpracticeMyStore.pageObjects.CartSummary;
import com.automationpracticeMyStore.pageObjects.ItemCatalogue;
import com.automationpracticeMyStore.pageObjects.ShoppingActions;
import com.automationpracticeMyStore.pageObjects.SigninPage;
import com.automationpracticeMyStore.pageObjects.UserAccount;
public class RegisteredUserTransaction {

	private WebDriver driver;
	private Actions action;

	private ItemCatalogue itemCatalogue;
	private Cart cart;
	private ShoppingActions shoppingActions;
	private CartSummary summary;
	private SigninPage signin;
	private UserAccount userAccount;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
		driver = new ChromeDriver();

		action = new Actions(driver);

		itemCatalogue = new ItemCatalogue(driver);
		cart = new Cart(driver);
		shoppingActions = new ShoppingActions(driver);
		signin = new SigninPage(driver);
		new SigninPage(driver);
		summary = new CartSummary(driver);
		userAccount = new UserAccount(driver);

		String baseUrl = "http://automationpractice.com/index.php";
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@AfterClass
	public void closeAll() {
		userAccount.getAccountLogout().click();
		driver.quit();
	}

	
	@Test(priority = 1)
	public void successfulRegisteredUserTransaction() {
		signin.SignInBtn().click();
		signin.setEmailField("test@test22.com");
		signin.setPasswordField("Test22");
		signin.getSignInBtn().click();

			
/*Selecting Dress*/
		Assert.assertTrue(itemCatalogue.getDressesBtn().isDisplayed());
		action.moveToElement(itemCatalogue.getDressesBtn()).perform();
		Assert.assertTrue(itemCatalogue.getSummerDressesBtn().isDisplayed());
		Assert.assertTrue(itemCatalogue.getCasualDressesBtn().isDisplayed());
		Assert.assertTrue(itemCatalogue.getEveningDressesBtn().isDisplayed());
		action.moveToElement(itemCatalogue.getSummerDressesBtn()).perform();
		itemCatalogue.getSummerDressesBtn().click();
		action.moveToElement(itemCatalogue.getSummerDressProduct(1)).perform();
		action.moveToElement(shoppingActions.getAddToCartBtn()).perform();
		Assert.assertTrue(shoppingActions.getAddToCartBtn().isDisplayed());
		action.click(shoppingActions.getAddToCartBtn()).build().perform();
		action.click(shoppingActions.getContinueShopingBtn()).build().perform();
		Assert.assertTrue(shoppingActions.getContinueShopingBtn().isDisplayed());
		action.moveToElement(cart.getCartTab()).perform();
		Assert.assertEquals(cart.getCartProductsQty().size(), 1);
		cart.getCartTabCheckOutBtn().click();
		summary.getCartProceedBtn().click();
			

	
/*Finalizing the cart*/
		summary.getCartProceedBtnTwo().click();
		
		
		summary.getCartSummTermsOfServiceCheck().click();
		summary.getCartProceedBtnTwo().click();
	
/*Payment Page*/
		
		summary.getCartSummPayByCheck().click();
		Assert.assertEquals(summary.getCartSummPayByCheckConfirm().getText(), "CHECK PAYMENT");
	

/*Confirmation of Order*/
		summary.getCartSummConfirmOrderBtn().click();

		Assert.assertTrue(summary.getCartSummSuccessMsg().isDisplayed());
		Assert.assertEquals(summary.getCartSummSuccessMsg().getText(), "Your order on My Store is complete.");
	}

}
