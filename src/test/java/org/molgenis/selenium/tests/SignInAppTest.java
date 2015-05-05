package org.molgenis.selenium.tests;

import org.molgenis.selenium.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInAppTest extends DriverFactory
{
	@Test public void test1()
	{
		//get signin app
		WebDriver driver = getDriver();
		driver.get("http://localhost:8080");
		SignInAppModel signin = new SignInAppModel(driver);

		//open the signin
		signin.open();
		//should result in a popup where we type username and password

		signin.signIn("admin", "blaat");

		//should show error messages
		Assert.assertTrue(signin.shows("The username or password you entered is incorrect"));

		signin.signIn("admin", "admin");

		//should show sign out button
		Assert.assertTrue(signin.shows("Sign out"));

		signin.signOut();

		//should show sign in button again
		Assert.assertTrue(signin.shows("Sign in"));
	}
}