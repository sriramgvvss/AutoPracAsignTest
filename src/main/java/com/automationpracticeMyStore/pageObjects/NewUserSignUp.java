/*Class file for all the objects and methods pretaining to Account creation section of signup page of automationpractice My Store app.*/
package com.automationpracticeMyStore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpracticeMyStore.utils.Utils;

public class NewUserSignUp {
	
	private WebDriver driver;
	
	public NewUserSignUp(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCreateAccountForm() {
		return Utils.waitForElementPresence(driver, By.id("create-account_form"), 30);
	}
	
	public WebElement getCreatAccountEmailField() {
		return Utils.waitForElementPresence(driver, By.id("email_create"), 30);
	}
	
	public WebElement getCreateAccountBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[@id=\"SubmitCreate\"]"), 30);
	}
	
	public void setCreateAccountEmailField(String email) {
		WebElement email1 = this.getCreatAccountEmailField();
		email1.clear();
		email1.sendKeys(email);
	}
	
	/****** ERRORS ******/
	
	public WebElement getEmailFieldHighlightedRed() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-error\"]"), 30);
	}
	
	public WebElement getEmailFieldHighlightedGreen() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-ok\"]"), 30);
	}
	
	public WebElement getEmailErrorMessage() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Invalid email address.\")]"), 30);
	}
	
	public WebElement getEmailBeenRegistered() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"An account using this email\")]"), 30);
	}
}
