package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BookHotelBase;

public class BookingFormPage extends BookHotelBase{

	Alert alert;
	
	@FindBy(id="txtFirstName")
	WebElement txtFirstName;
	
	@FindBy(id="txtLastName")
	WebElement txtLastName;
	
	@FindBy(id="txtEmail")
	WebElement txtEmail;
	
	@FindBy(id="txtPhone")
	WebElement txtPhone;
	
	@FindBy(xpath="//textarea")
	WebElement txtAddress;
	
	Select selectCity=new Select(driver.findElement(By.name("city")));
	
	Select selectState=new Select(driver.findElement(By.name("state")));
	
	Select selectPersons=new Select(driver.findElement(By.name("persons")));
	
	@FindBy(id="txtCardholderName")
	WebElement txtCardholderName;
	
	@FindBy(id="txtDebit")
	WebElement txtDebit;
	
	@FindBy(id="txtCvv")
	WebElement txtCvv;
	
	@FindBy(id="txtMonth")
	WebElement txtMonth;
	
	@FindBy(id="txtYear")
	WebElement txtYear;
	
	@FindBy(id="btnPayment")
	WebElement btnPayment;
	
	public BookingFormPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		String formPageTitle=driver.getTitle();
		return formPageTitle;
	}
	
	public String getAlert() {
		btnPayment.click();
		alert=driver.switchTo().alert();
		String alertMessage=alert.getText();
		alert.accept();
		return alertMessage;
	}
	
	public void addFName() {
		txtFirstName.sendKeys("firstname");
		System.out.println("First Name entered: firstname");
	}
	
	public void addLName() {
		txtLastName.sendKeys("lastname");
		System.out.println("Last Name entered: lastname");
	}
	
	public void addInvalidEmail() {
		txtEmail.sendKeys("email");
		System.out.println("Email entered: email");
	}
	
	public void addValidEmail() {
		txtEmail.clear();
		txtEmail.sendKeys("mail@email.com");
		System.out.println("Email entered: mail@email.com");
	}
	
	public void addInvalidMob() {
		txtPhone.sendKeys("923456412");
		System.out.println("Mobile Number entered: 923456412");
	}
	
	public void addInvalidMobAgain() {
		txtPhone.clear();
		txtPhone.sendKeys("1234567890");
		System.out.println("Mobile Number entered: 1234567890");
	}
	
	public void addValidMob() {
		txtPhone.clear();
		txtPhone.sendKeys("7894561230");
		System.out.println("Mobile Number entered: 7894561230");
	}
	
	public void addPerson() {
		String value=selectPersons.getFirstSelectedOption().getText();
		System.out.println("Number of guests field default value: "+value);
		selectPersons.selectByValue("3");
		System.out.println("Number of guests changed to value: 3");
	}
	
	public void addAddress() {
		txtAddress.sendKeys("Address");
		System.out.println("Address entered: Address");
	}
	
	public void addCity() {
		selectCity.selectByValue("Chennai");
		System.out.println("City selected: Chennai");
	}
	
	public void addState() {
		selectState.selectByValue("Tamilnadu");
		System.out.println("State selected: Tamilnadu");
	}
	
	public void addCardName() {
		txtCardholderName.sendKeys("card holder name");
		System.out.println("Card Holder Name entered: card holder name");
	}
	
	public void addCardNumber() {
		txtDebit.sendKeys("123546879");
		System.out.println("Card number entered: 123546879");
	}
	
	public void addCvv() {
		txtCvv.sendKeys("159");
		System.out.println("Cvv entered: 159");
	}
	
	public void addExpMonth() {
		txtMonth.sendKeys("May");
		System.out.println("Expiration month entered: May");
	}
	
	public void addExpYear() {
		txtYear.sendKeys("2022");
		System.out.println("Expiration Year entered: 2022");
	}
	
	public void confirmBooking() {
		btnPayment.click();
	}
	
}
