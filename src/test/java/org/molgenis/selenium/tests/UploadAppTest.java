package org.molgenis.selenium.tests;

import org.apache.commons.io.FileUtils;
import org.molgenis.selenium.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class UploadAppTest extends DriverFactory
{
	@Test public void test1() throws IOException, InterruptedException
	{
		//get the upload app
		WebDriver driver = getDriver();
		driver.get(Constants.MOLGENIS_HOME);

		SignInAppModel signin = new SignInAppModel(driver);
		UploadAppModel upload = new UploadAppModel(driver);

		//signin
		signin.open();
		signin.signIn("admin", "admin");

		//open upload app
		upload.open();

		//upload the EMX file from documentation
		File f = downloadUrlToFile("https://github.com/molgenis/molgenis/wiki/example2.xlsx", ".xlsx");
		upload.setFile(f);

		//step2 (use defaults)
		upload.next();
		upload.next();
		Assert.assertEquals("", upload.getValidationError());
	}

	private File downloadUrlToFile(String url, String suffix) throws IOException
	{
		File f = File.createTempFile("tmp", suffix);
		FileUtils.copyURLToFile(new URL(url), f);
		System.out.println("downloaded file: " + f);
		return f;
	}

}
