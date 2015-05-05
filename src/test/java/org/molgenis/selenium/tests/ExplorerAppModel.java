package org.molgenis.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * This is a model of the MOLGENIS login user interface
 */
public class ExplorerAppModel
{
	private WebDriver driver;

	public static String DATASET_SELECT = "dataset-select";
	public static String DATASET_TITLE = "entity-class-name";

	public ExplorerAppModel(WebDriver driver)
	{
		this.driver = driver;
	}

	public void open()
	{
		driver.findElement(By.partialLinkText("Data Explorer")).click();
	}

	public void openViaUrl(String url)
	{
	}

	public String getSelectedEntity()
	{
		return driver.findElement(By.id(DATASET_TITLE)).getText();
	}

}
