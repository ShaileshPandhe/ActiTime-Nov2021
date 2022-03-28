package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	


@FindBy (xpath = "//input[@name='username']")
private WebElement userName ;

@FindBy (xpath = "//input[@name='pwd']")
private WebElement password ;

@FindBy (xpath = "//input[@type='checkbox']")
private WebElement keepMeLoginCheckBox ;

@FindBy (xpath = "//a[@id='loginButton']")
private WebElement Login ;

private WebDriver driver;
private WebDriverWait wait;

public LoginPage (WebDriver driver)

{
	PageFactory.initElements(driver, this);
	this.driver = driver;
	wait = new WebDriverWait(driver, 30);
}
public void sendUserName() {
	wait.until(ExpectedConditions.visibilityOf(userName));
	userName.sendKeys("admin");
}

public void sendPassword() {
	wait.until(ExpectedConditions.visibilityOf(password));
	password.sendKeys("manager");
}

public void clickOnKeepMeLogin() {
	wait.until(ExpectedConditions.visibilityOf(keepMeLoginCheckBox));
	
	if (! (keepMeLoginCheckBox.isSelected()))
	{
	keepMeLoginCheckBox.click();
	}
	else
	{
		System.out.println("keep Me Login Checkbox already selected");
	}
}
public void clickOnLogin() {
	Login.click();
}



}
