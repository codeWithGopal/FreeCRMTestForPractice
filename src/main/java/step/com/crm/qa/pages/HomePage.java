package step.com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import step.com.crm.qa.base.TestBase;
import step.com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	

    TestUtil testUtil = new TestUtil();
    
	
	
	@FindBy(xpath= "//td[@class='headertext']")
	WebElement usernameLabel;
	
	@FindBy(xpath= "//a[@title='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath= "//a[@title='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomePageTitle() {
		
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink() {
		
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksPage() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public boolean verifyCorrectUsername() {
		
		return usernameLabel.isDisplayed();
	}
	
	public void clickOnNewContactslink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	
	

}
