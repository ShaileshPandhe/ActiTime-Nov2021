package pack123;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.ApplicationHeaderPage;
import pom.LoginPage;

public class TestClass {
 
	
public static void main(String[] args) throws InterruptedException {

	System.setProperty("webdriver.chrome.driver", "D:\\Velocity Downlods\\chromedriver_win32\\chromedriver.exe");

	WebDriver driver = new ChromeDriver();

	driver.get("http://localhost/tasks/otasklist.do");
	
LoginPage loginPage = new LoginPage(driver);

loginPage.sendUserName();
Thread.sleep(5000);
loginPage.sendPassword();
loginPage.clickOnKeepMeLogin();
loginPage.clickOnLogin();

ApplicationHeaderPage applicationHeaderPage = new ApplicationHeaderPage(driver);

applicationHeaderPage.clickOntimeTrack();
applicationHeaderPage.clickOnTask();
applicationHeaderPage.clickOnusers();
applicationHeaderPage.clickOnReports();
applicationHeaderPage.clickOnworkSchedule();
applicationHeaderPage.clickOnlogout();
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
}