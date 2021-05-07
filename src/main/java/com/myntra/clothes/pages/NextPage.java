package com.myntra.clothes.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.myntra.clothes.genericlib.WebActionUtil;

public class NextPage extends BasePage {

	public NextPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
		}
	
	@FindBy(xpath = "//h3")
	private List<WebElement> shirtList;
	
	@FindBy(xpath = "//span[contains(@class,'product-wishlistFlex')]")
	private List<WebElement> wishlist;
	
	@FindBy(xpath = "//span[text()='Wishlist']")
	private WebElement wishListpage;

	public List<WebElement> getShirtList() {
		return shirtList;
	}

	public List<WebElement> getWishlist() {
		return wishlist;
	}

	public WebElement getWishListpage() {
		return wishListpage;
	}
	
	public WishListPage wishlistadd(int num) {
		
		List<WebElement> list = new ArrayList<WebElement>(getShirtList());
		for (int i = 0; i < num; i++) {
			webActionUtil.moveToElement(list.get(i));
			for (WebElement webElement : getWishlist()) {
				if(webElement.isDisplayed()) {
					webElement.click();
				}
			}
		}
		webActionUtil.elementClick(getWishListpage());
		return new WishListPage(driver, webActionUtil);
	}
}
