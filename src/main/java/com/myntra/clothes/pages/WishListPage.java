package com.myntra.clothes.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.myntra.clothes.genericlib.WebActionUtil;

public class WishListPage extends BasePage {

	public WishListPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
	}
	
	@FindBy(xpath = "//div[@class='itemcard-actionDiv']")
	private List<WebElement> movetoBag;
	
	@FindAll({@FindBy(xpath = "//button[@class='sizeselect-sizeButton']"),@FindBy(xpath = "//b[text()='8-9Y']/..")})
	private WebElement selectSize;
	
	@FindBy(xpath = "//div[text()='Done']")
	private WebElement doneButton;

	@FindBy(xpath = "//span[text()='Bag']")
	private WebElement bagButton;

	public List<WebElement> getMovetoBag() {
		return movetoBag;
	}

	public WebElement getSelectSize() {
		return selectSize;
	}

	public WebElement getDoneButton() {
		return doneButton;
	}

	public WebElement getBagButton() {
		return bagButton;
	}
	
	public BagPage assToBag() {
		List<WebElement> list = new ArrayList<WebElement>();
		for (WebElement webElement : getMovetoBag()) {
			list.add(webElement);
		}
		
		for (int i = 0; i < 2; i++) {
			webActionUtil.elementClick(list.get(i));
			webActionUtil.elementClick(getSelectSize());
			webActionUtil.elementClick(getDoneButton());
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

		for (int i = 0; i < 1; i++) {
			webActionUtil.elementClick(list.get(i));
			webActionUtil.elementClick(getSelectSize());
			webActionUtil.elementClick(getDoneButton());
		}
		
		webActionUtil.elementClick(getBagButton());
		return new BagPage(driver, webActionUtil);
	}
}
