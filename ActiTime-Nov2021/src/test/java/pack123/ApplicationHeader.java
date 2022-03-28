package pack123;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.ApplicationHeaderPage;
import pom.LoginPage;

public class ApplicationHeader {

	private WebDriver driver;
	private ApplicationHeaderPage applicationHeaderPage;
	private LoginPage loginPage;
	@BeforeClass
	public void launchBrowser()  {
		
		System.out.println("launchBrowser");
		
		System.setProperty("webdriver.chrome.driver", "D:\\Velocity Downlods\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	@BeforeMethod
		public void loginToApplication() throws InterruptedException  {
		
		System.out.println("loginToApplication");
		
		driver.get("http://localhost/tasks/otasklist.do");
		
		loginPage = new LoginPage(driver);
		
		loginPage.sendUserName();
		Thread.sleep(5000);
		loginPage.sendPassword();
		loginPage.clickOnKeepMeLogin();
		loginPage.clickOnLogin();
		
		applicationHeaderPage = new ApplicationHeaderPage(driver);
		Thread.sleep(5000);
		}
	
	@Test
		public void verifyUserTab()  {
		
		System.out.println("verifyUserTab");
		
		applicationHeaderPage.clickOntimeTrack();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		if (url.equals("http://localhost/tasks/otasklist.do"));

		{
			System.out.println("Pass");
		}
	if (title.equals("actiTIME -  Enter Time-Track"));

	{
		System.out.println("Pass");
	}
		}
	
	@Test
public void verifyReportButton()  {
		
		System.out.println("verifyReportButton");
		
		applicationHeaderPage.clickOnReports();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		if (url.equals("http://localhost/reports/reports.do"));

		{
			System.out.println("Pass");
		}
	if (title.equals("actiTIME - Saved Reports"));

	{
		System.out.println("Pass");
	}
		}
	
	@AfterMethod
	public void logout()  {
	
	System.out.println("logout");
	
	applicationHeaderPage.clickOnlogout();
	}
	
	@AfterClass
	public void closeBrowser()  {
		
		System.out.println("closeBrowser");
		
		driver.close();
		}
}
