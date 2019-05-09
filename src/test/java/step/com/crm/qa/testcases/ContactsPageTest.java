package step.com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import step.com.crm.qa.base.TestBase;
import step.com.crm.qa.pages.ContactsPage;
import step.com.crm.qa.pages.HomePage;
import step.com.crm.qa.pages.LogInPage;
import step.com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LogInPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	String sheetName = "contacts";
	
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LogInPage();
      	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
		
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest() {
		boolean flag3 = contactsPage.verifycontactsLabel();
		Assert.assertTrue(flag3);
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void validateCreateNewContactTest(String title, String firstName, String lastName, String company) {
		homePage.clickOnNewContactslink();
		contactsPage.createNewContact(title, firstName, lastName, company);
		
		
	}
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}

}
