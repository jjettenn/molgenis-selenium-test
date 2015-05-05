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
		driver.get(Constants.MOLGENIS_HOME);

		//get homepage
		explorer = new ExplorerAppModel(driver);
	}

	@Test public void test1()
	{
		explorer.open();
	}

	@Test public void test2_openViaUrl()
	{
		driver.get(Constants.MOLGENIS_HOME + "/menu/main/dataexplorer?entity=org_molgenis_test_TypeTest");

		Assert.assertEquals("TypeTest", explorer.getSelectedEntity());

	}
}