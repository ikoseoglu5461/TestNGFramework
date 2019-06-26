package com.syntax.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest extends BaseClass {

	@Test(groups = "smoke")
	public void loginToOrangeHRM() {

		LoginPageWithoutPageFactory login = new LoginPageWithoutPageFactory();

		test.info("Loggin in with valid credentials");
		CommonMethods.sendText(login.username, "Admin");
		CommonMethods.sendText(login.password, "NT1zgHXd@4");
		CommonMethods.click(login.btnLogin);

		test.info("Verifying dashboard text is displayed");
		HomePage home = new HomePage();
		boolean isDisplayed = home.dashboardText.isDisplayed();

		Assert.assertTrue(isDisplayed);
		test.pass("Succesfully logged in");
	}

	@Test(groups = "smoke")
	public void doLogin() {
		test = report.createTest("Login verification 2");
		LoginPage login = new LoginPage();
		CommonMethods.sendText(login.userName, ConfigsReader.getProperty("username"));
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommonMethods.click(login.loginBtn);

		HomePage home = new HomePage();
		boolean isDisplayed = home.dashboardText.isDisplayed();
		Assert.assertTrue(false);
	}

	/*
	 * verify user is unable to login with wrong credentials
	 */
	@Test(groups = "regression")
	public void negativeLogin() {

		LoginPage login = new LoginPage();

		login.login("admins", "test");
		String errorText = login.message.getText();

		Assert.assertEquals(errorText, "Invalid Credentials");
	}
}