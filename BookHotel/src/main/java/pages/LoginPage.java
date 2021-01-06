package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BookHotelBase;
public class LoginPage extends BookHotelBase{
	public static Properties prop;
	
	
	@FindBy(xpath="//h1")
	WebElement loginPageHeading;
	
	@FindBy(xpath="//td[text()='UserName:']//following-sibling::td/input")
	WebElement uname;
	
	@FindBy(xpath="//td[text()='Password:']//following-sibling::td/input")
	WebElement pword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@id='userErrMsg']")
	WebElement userError;
	
	@FindBy(xpath="//div[@id='pwdErrMsg']")
	WebElement pwdError;

	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		prop= new Properties();
		try {
			FileInputStream fin= new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//config//config.properties");
			prop.load(fin);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getHeading() {
		String pageHeading=loginPageHeading.getText();
		return pageHeading;
	}
	
	public String getUsrError() {
		loginBtn.click();
		String uError= userError.getText();
		return uError;
	}
	
	public String getPwdError() {
		uname.sendKeys("Username");
		loginBtn.click();
		String pError= pwdError.getText();
		return pError;
	}
	
	public void loginFail() {
		pword.sendKeys("Password");
		loginBtn.click();
		Alert alert= driver.switchTo().alert();
		String alertMsg=alert.getText();
		System.out.println("Alert message displayed on login with invalid credentials: "+alertMsg);
		alert.accept();
		System.out.println("Alert box closed");
	}
	
	public void loginUser() {
		uname.clear();
		pword.clear();
		String userName=prop.getProperty("username");
		String passWord=prop.getProperty("password");
		uname.sendKeys(userName);
		System.out.println("Username entered");
		pword.sendKeys(passWord);
		System.out.println("Password entered");
		loginBtn.click();
		System.out.println("Login button clicked");
	}
	
}
