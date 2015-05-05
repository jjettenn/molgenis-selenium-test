package org.molgenis.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This is a model of the MOLGENIS login user interface
 */
public class SignInAppModel
{
	private WebDriver driver;

	//IDs of user interface elements
	public static String OPEN_BUTTON = "login-open";
	public static String USERNAME_FIELD = "loginUsername";
	public static String PASSWORD_FIELD = "loginPassword";
	public static String SIGNIN_BUTTON = "login-btn";
	public static String SIGNOUT_BUTTON = "login-logout";

	//TODO: ease testing by giving all relevant elements an ID value

	public SignInAppModel(WebDriver driver)
	{
		this.driver = driver;
	}

	public void open()
	{
		//click the sign in button on home page
		driver.findElement(By.id(OPEN_BUTTON)).click();
	}

	public void signIn(String user, String password)
	{
		//fill in the user name
		driver.findElement(By.id(USERNAME_FIELD)).clear();
		driver.findElement(By.id(USERNAME_FIELD)).sendKeys(user);

		//fill in the password
		driver.findElement(By.id(PASSWORD_FIELD)).clear();
		driver.findElement(By.id(PASSWORD_FIELD)).sendKeys(password);

		//click the sign in button on login page
		driver.findElement(By.id(SIGNIN_BUTTON)).click();
	}

	public boolean shows(String s)
	{
		return driver.getPageSource().contains(s);
	}

	public void signOut()
	{
		driver.findElement(By.id(SIGNOUT_BUTTON)).click();
	}
}
