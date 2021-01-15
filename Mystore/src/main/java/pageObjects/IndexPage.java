/**
 * 
 */
package pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.BaseClass;

/**
 * @author draj
 *
 */
public class IndexPage extends BaseClass {
	
	Action action=new Action();
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signIn;
	
	@FindBy(xpath="//a[contains(text(),'Contact Us')]")
	WebElement contactUs;
	
	@FindBy(xpath="//img[@class='logo img-responsive')]")
	WebElement Logo;

	
	public IndexPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public loginPage clickonSignIn()
	{
		action.click(driver, signIn);
		return new loginPage();
	}
	
	public contactUs clickonContact()
	{
		action.click(driver, contactUs);
		return new contactUs();
	}
	
	public boolean verifyLogo()
	{
		action.fluentWait(driver, Logo, 10);
		return action.isDisplayed(driver, Logo);
	}
	public String verifyTitle()
	{
		action.fluentWait(driver, Logo, 10);

		String ActTitle= action.getTitle(driver);
		//
		return ActTitle;
	}
}
