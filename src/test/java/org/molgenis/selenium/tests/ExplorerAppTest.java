package org.molgenis.selenium.tests;

import org.molgenis.selenium.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplorerAppTest extends DriverFactory
{
	ExplorerAppModel explorer;
	WebDriver driver;

	@BeforeMethod public void setUp() throws Exception
	{
		driver = getDriver();

		//todo: make this env variable
		driver.get("http://molgenis01.target.rug.nl");

		//get homepage
		explorer = new ExplorerAppModel(driver);
	}

	@Test public void test1()
	{
		explorer.open();
	}

	@Test public void test2_openViaUrl()
	{
		driver.get("https://molgenis01.target.rug.nl/menu/main/dataexplorer?entity=org_molgenis_test_TypeTest");

		Assert.assertEquals("TypeTest", explorer.getSelectedEntity());

	}
}