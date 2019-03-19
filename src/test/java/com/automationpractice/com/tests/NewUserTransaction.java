package com.automationpractice.com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationpracticeMyStore.pageObjects.*;

public class NewUserTransaction {

	private WebDriver driver;
	private Actions action;

	private ItemCatalogue itemCatalogue;
	private ShoppingActions shoppingActions;
	private CartSummary summary;
	private SigninPage signinForm;
	private NewUserSignUpDetails newUserSignUpDetails;
	private NewUserSignUp newUserSignUp;
	private UserAccount userAccount;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
		driver = new ChromeDriver();

		action = new Actions(driver);

		itemCatalogue = new ItemCatalogue(driver);
		new Cart(driver);
		shoppingActions = new ShoppingActions(driver);
		signinForm = new SigninPage(driver);
		newUserSignUp = new NewUserSignUp(driver);
		newUserSignUpDetails = new NewUserSignUpDetails(driver);
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
	public void SucessfulTransaction() {
		Assert.assertTrue(itemCatalogue.getDressesBtn().isDisplayed());
		action.moveToElement(itemCatalogue.getDressesBtn()).perform();

		action.moveToElement(itemCatalogue.getCasualDressesBtn()).perform();
		itemCatalogue.getCasualDressesBtn().click();
		action.moveToElement(itemCatalogue.getCasualDressProduct(1)).perform();
		action.moveToElement(shoppingActions.getAddToCartBtn()).perform();
		action.click(shoppingActions.getAddToCartBtn()).build().perform();

		Assert.assertTrue(shoppingActions.getAddToCartBtn().isDisplayed());

		shoppingActions.getProceedToCheckoutBtn().click();
			
		summary.getCartProceedBtn().click();

/*Signup for a new customer*/
		
		Assert.assertTrue(newUserSignUp.getCreateAccountForm().isDisplayed());
		Assert.assertTrue(newUserSignUp.getCreatAccountEmailField().isDisplayed());
		Assert.assertTrue(newUserSignUp.getCreateAccountBtn().isDisplayed());
		
		newUserSignUp.setCreateAccountEmailField("test86@test86.com");
		newUserSignUp.getCreateAccountBtn().click();
		
		Assert.assertTrue(signinForm.getSignInForm().isDisplayed());

		newUserSignUpDetails.setCustomerTitleMr();
		newUserSignUpDetails.setCustomerFirstNameField("John");
		newUserSignUpDetails.setCustomerLastNameField("Doe");
		newUserSignUpDetails.setCustomerPasswordField("Test23");
		newUserSignUpDetails.selectCustomerDateOfBirthDay("20");
		newUserSignUpDetails.selectCustomerDateOfBirthMonth("10");
		newUserSignUpDetails.selectCustomerDateOfBirthYear("2000");
		newUserSignUpDetails.setAddressField("Centar");
		newUserSignUpDetails.setCityField("Novi Sad");
		newUserSignUpDetails.selectState("7");
		newUserSignUpDetails.setPostalCodeField("21000");
		newUserSignUpDetails.setHomePhoneField("056");
		newUserSignUpDetails.setMobilePhoneField("066");
		newUserSignUpDetails.setAddressAliasField("My Address");
		newUserSignUpDetails.getRegisterBtn().click();
	

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
