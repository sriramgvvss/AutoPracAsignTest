/*Class file for all the objects and methods pretaining to Home page of automationpractice My Store app.*/
package com.automationpracticeMyStore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpracticeMyStore.utils.Utils;

public class Homepage {
	
	private WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement SignInBtn() {
		return Utils.waitToBeClickable(driver,By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a"),30);
		
	}
	public WebElement getSignInBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[contains(text(), \"Sign in\")]"), 30);
	}
	
	public WebElement getHomePageSlider() {
		return Utils.waitForElementPresence(driver, By.id("homepage-slider"), 30);
	}
	
	public WebElement getContainerPopular() {
		return Utils.waitForElementPresence(driver, By.id("homefeatured"), 30);
	}
	
	public WebElement getFooterBaners() {
		return Utils.waitForElementPresence(driver, By.id("htmlcontent_home"), 30);
	}	
}
