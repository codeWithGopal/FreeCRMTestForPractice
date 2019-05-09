package step.com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import step.com.crm.qa.base.TestBase;

public class LogInPage extends TestBase {
	
	
	//Page Factory - OR(OBJECT REPO)
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(linkText="Sign Up")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class, 'img-responsive')]")
	WebElement crmLogo;
	
	
	public LogInPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pw) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pw);
		Thread.sleep(1000);
		loginBtn.click();
		
		return new HomePage();
		
	}

}
