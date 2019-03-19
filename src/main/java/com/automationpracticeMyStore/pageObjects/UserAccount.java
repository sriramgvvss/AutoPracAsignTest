/*Class file for all the objects and methods pretaining to registered User Account page of automationpractice My Store app.*/

package com.automationpracticeMyStore.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpracticeMyStore.utils.Utils;

public class UserAccount {
	
	private WebDriver driver;
	
	public UserAccount(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getAccountBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@title=\"View my customer account\"]"), 30);
	}
	
	public WebElement getAccountLogout() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[@title=\"Log me out\"]"), 30);
	}
	
	public WebElement getAccountOrderHistoryBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//span[contains(text(), \"Order history and details\")]"), 30);
	}
	
	public WebElement getAccountOrderListTable() {
		return Utils.waitToBeClickable(driver, By.xpath("//table[@id=\"order-list\"]"), 30);
	}
	
	public List<WebElement> getAccountOrdersLis() {
		return driver.findElements(By.xpath("//table[@id=\"order-list\"]/tbody/tr"));
	}
}
