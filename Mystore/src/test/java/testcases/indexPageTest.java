/**
 * 
 */
package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import actionDriver.Action;
import base.BaseClass;
import pageObjects.IndexPage;

/**
 * @author draj
 *
 */
public class indexPageTest extends BaseClass {
	
	Action action=new Action();
	IndexPage index;
	@BeforeMethod
	public void setup() throws Exception
	{
		launchApp();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	@Test
	public void verifyIndexPageTest()
	{
		index=new IndexPage();
		boolean result =index.verifyLogo();
		Assert.assertTrue(result);
	}
	@Test
	public void verifyTitle()
	{
	String ActTitle=index.verifyTitle();
	Assert.assertEquals(ActTitle, "My Store");
	
	}
	
}
