package org.molgenis.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * Created by mswertz on 05/05/15.
 */
public class UploadAppModel
{
	private WebDriver driver;

	public static String UPLOAD_ERROR = "upload-error";
	//ugly, source of errors varies
	public static String MOLGENIS_MESSAGE = "molgenis-alert";

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

	public void next()
	{
		driver.findElement(By.partialLinkText("Next")).click();
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
			value = driver.findElement(By.id(UPLOAD_ERROR)).getText();
		}
		catch (Exception e)
		{
			try
			{
				value = driver.findElement(By.id(MOLGENIS_MESSAGE)).getText();
			}
			catch (Exception e2)
			{
				value = "";
			}
		}
		System.out.println("getAlert(): " + value);
		return value;
	}
}
