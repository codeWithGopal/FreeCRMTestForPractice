package step.com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import step.com.crm.qa.base.TestBase;
import step.com.crm.qa.pages.ContactsPage;
import step.com.crm.qa.pages.HomePage;
import step.com.crm.qa.pages.LogInPage;
import step.com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LogInPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	// test cases should be independent with each other
	
	// before each test case launch the browser and log in and after each test case close the browser 
	//@test- execute it 

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LogInPage();
		contactsPage = new ContactsPage();
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home Page Title not matched");
	}
	
	@Test(priority=2)
	public void verifyUsernameTest() {
	
		testUtil.switchToFrame();
		Boolean flag1 = homePage.verifyCorrectUsername();
		Assert.assertTrue(flag1);
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
		

}
