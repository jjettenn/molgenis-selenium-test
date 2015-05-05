package org.molgenis.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class UploadAppModel
{
	private WebDriver driver;

	public static String MOLGENIS_ALERT = "molgenis-alert";

	public UploadAppModel(WebDriver driver)
	{
		this.driver = driver;
	}

	public void open()
	{
		driver.findElement(By.partialLinkText("Upload")).click();
	}

	public void setFile(File file)
	{
		driver.findElement(By.name("upload")).sendKeys(file.getAbsolutePath());
	}

	public void next() throws InterruptedException
	{
		driver.findElement(By.partialLinkText("Next")).click();

		//to accomodate for Ajax stuff
		Thread.sleep(1000);
	}

	public void addToPackage(String hospital)
	{
		driver.findElement(By.xpath("//input[@value='hospital']")).click();
	}

	public String getValidationError()
	{
		String value = "";

		try
		{
			value = driver.findElement(By.id(MOLGENIS_ALERT)).getText();
		}
		catch (Exception e2)
		{
			value = "";
		}

		System.out.println("getAlert(): " + value);
		return value;
	}
}
