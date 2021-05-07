package com.myntra.clothes.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.myntra.clothes.genericlib.WebActionUtil;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
	}
	
	@FindBy(id = "mobileNumberPass")
	private WebElement userNameTextField;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//button[text()='LOGIN']")
	private WebElement loginButton;

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public HomePage signIn(String username, String password) {
		webActionUtil.enterData(userNameTextField, username);
		webActionUtil.enterData(passwordTextField, password);
		webActionUtil.elementClick(loginButton);
		return new HomePage(driver, webActionUtil);
	}

}
