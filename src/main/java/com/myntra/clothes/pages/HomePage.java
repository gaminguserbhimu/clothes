package com.myntra.clothes.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.myntra.clothes.genericlib.WebActionUtil;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
		}
	
	@FindBy(xpath = "//div[@class='desktop-navLink']")
	private List<WebElement> menulist;
	
	@FindBy(xpath = "//a[@style='color:;']")
	private List<WebElement> subMenuList;

	public List<WebElement> getMenulist() {
		return menulist;
	}

	public List<WebElement> getSubMenuList() {
		return subMenuList;
	}

	public NextPage shirt(String menu,String type)
	{
		for (WebElement webElement : menulist) {
			if (webElement.getText().equalsIgnoreCase(menu)) {
				webActionUtil.moveToElement(webElement);
				break;
			}
		}
		for (WebElement webElement : subMenuList) {
			if (webElement.getText().equalsIgnoreCase(type)) {
				webActionUtil.elementClick(webElement);
			}
		}
		
		return new NextPage(driver, webActionUtil);
	}
}
