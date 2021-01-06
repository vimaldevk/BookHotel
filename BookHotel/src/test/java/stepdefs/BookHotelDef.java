package stepdefs;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;

import base.BookHotelBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BookingFormPage;
import pages.ConfirmBookingPage;
import pages.LoginPage;

public class BookHotelDef extends BookHotelBase{
	
	LoginPage loginpage;
	BookingFormPage bookingformpage;
	ConfirmBookingPage confirmbookingpage;
	
	@Before
	public void setup() {
		Reporter.assignAuthor("Vimal Dev K(1039484)");
	}
	
	@Given("^Hotel Booking Login page loaded$")
	public void hotel_Booking_Login_page_loaded() throws Throwable {
		BookHotelBase.initialize();
	    loginpage=new LoginPage();
	    String heading=loginpage.getHeading();
	    Assert.assertEquals("Page Heading verified", "Hotel Booking Application", heading);
	    System.out.println("Login page displayed successfully with heading: "+heading);
	}
	
	@When("^User logs into the Room Booking application$")
	public void user_logs_into_the_Room_Booking_application() throws Throwable {
	    loginpage= new LoginPage();
	    String userError=loginpage.getUsrError();
	    Assert.assertEquals("Username Error verified", "* Please enter userName.",userError);
	    System.out.println("Error message displayed for blank Username as "+userError);
	    String pwdError=loginpage.getPwdError();
	    Assert.assertEquals("Password Error verified", "* Please enter password.",pwdError);
	    System.out.println("Error message displayed for blank Password as "+pwdError);
	    loginpage.loginFail();
	    loginpage.loginUser();
	}

	@When("^User fill the Hotel Booking Form$")
	public void user_fill_the_Hotel_Booking_Form() throws Throwable {
		String alertMessage;
		bookingformpage=new BookingFormPage();
	    String formPageTitle=bookingformpage.getPageTitle();
	    Assert.assertEquals("Hotel Booking Form page title", "Hotel Booking", formPageTitle);
	    System.out.println("Hotel Booking Form page loaded with title: "+formPageTitle);
	    alertMessage=bookingformpage.getAlert();
	    Assert.assertEquals("First Name field Alert message", "Please fill the First Name", alertMessage);
	    System.out.println("Alert message displayed on blank First Name: "+alertMessage);
	    System.out.println("Alert accepted");
	    
	    bookingformpage.addFName();//First Name entered
	    alertMessage=bookingformpage.getAlert();
	    Assert.assertEquals("Last Name field Alert message", "Please fill the Last Name", alertMessage);
	    System.out.println("Alert message displayed on blank Last Name: "+alertMessage);
	    System.out.println("Alert accepted");
	    
	    bookingformpage.addLName();//Last Name entered
	    alertMessage=bookingformpage.getAlert();
	    Assert.assertEquals("Email field Alert message", "Please fill the Email", alertMessage);
	    System.out.println("Alert message displayed on blank Email: "+alertMessage);
	    System.out.println("Alert accepted");
	    
	    bookingformpage.addInvalidEmail();//Invalid email entered
	    alertMessage=bookingformpage.getAlert();
	    Assert.assertEquals("Email field Alert message", "Please enter valid Email Id.", alertMessage);
	    System.out.println("Alert message displayed on invalid Email: "+alertMessage);
	    System.out.println("Alert accepted");
	    
	    bookingformpage.addValidEmail();//Valid email entered
	    alertMessage=bookingformpage.getAlert();
	    Assert.assertEquals("Mobile No field Alert message", "Please fill the Mobile No.", alertMessage);
	    System.out.println("Alert message displayed on blank Mobile No: "+alertMessage);
	    System.out.println("Alert accepted");
	    
	    bookingformpage.addInvalidMob();//Invalid mobile no entered
	    alertMessage=bookingformpage.getAlert();
	    Assert.assertEquals("Mobile No field Alert message", "Please enter valid Contact no.", alertMessage);
	    System.out.println("Alert message displayed on Invalid Mobile No: "+alertMessage);
	    System.out.println("Alert accepted");
	    
	    bookingformpage.addInvalidMobAgain();//Invalid mobile no entered
	    alertMessage=bookingformpage.getAlert();
	    Assert.assertEquals("Mobile No field Alert message", "Please enter valid Contact no.", alertMessage);
	    System.out.println("Alert message displayed on Invalid Mobile No: "+alertMessage);
	    System.out.println("Alert accepted");
	    
	    bookingformpage.addValidMob();//Valid mobile no entered
	    bookingformpage.addPerson();//Person number selected
	    bookingformpage.addAddress();//Address added
	    alertMessage=bookingformpage.getAlert();
	    Assert.assertEquals("City field Alert message", "Please select city", alertMessage);
	    System.out.println("Alert message displayed on blank city: "+alertMessage);
	    System.out.println("Alert accepted");
	    
	    bookingformpage.addCity();//City selected
	    alertMessage=bookingformpage.getAlert();
	    Assert.assertEquals("State field Alert message", "Please select state", alertMessage);
	    System.out.println("Alert message displayed on blank state: "+alertMessage);
	    System.out.println("Alert accepted");
	    
	    bookingformpage.addState();//State selected
	    alertMessage=bookingformpage.getAlert();
	    Assert.assertEquals("Card holder name field Alert message", "Please fill the Card holder name", alertMessage);
	    System.out.println("Alert message displayed on blank Card holder name: "+alertMessage);
	    System.out.println("Alert accepted");
	    
	    bookingformpage.addCardName();//Card Name entered
	    alertMessage=bookingformpage.getAlert();
	    Assert.assertEquals("Debit card number field Alert message", "Please fill the Debit card Number", alertMessage);
	    System.out.println("Alert message displayed on blank Debit card number: "+alertMessage);
	    System.out.println("Alert accepted");
	    
	    bookingformpage.addCardNumber();//Debit Card no entered
	    alertMessage=bookingformpage.getAlert();
	    Assert.assertEquals("CVV field Alert message", "Please fill the CVV", alertMessage);
	    System.out.println("Alert message displayed on blank CVV: "+alertMessage);
	    System.out.println("Alert accepted");
	    
	    bookingformpage.addCvv();//CVV entered
	    alertMessage=bookingformpage.getAlert();
	    Assert.assertEquals("Expiration month field Alert message", "Please fill expiration month", alertMessage);
	    System.out.println("Alert message displayed on blank Expiration month: "+alertMessage);
	    System.out.println("Alert accepted");
	    
	    bookingformpage.addExpMonth();//Expiration month entered
	    alertMessage=bookingformpage.getAlert();
	    Assert.assertEquals("Expiration year field Alert message", "Please fill the expiration year", alertMessage);
	    System.out.println("Alert message displayed on blank Expiration year: "+alertMessage);
	    System.out.println("Alert accepted");
	    
	    bookingformpage.addExpYear();//Expiration Year entered
	    bookingformpage.confirmBooking();//Confirm Booking button click
	    System.out.println("Confirm Booking button clicked");
	}

	@Then("^User should be able to book Hotel Room$")
	public void user_should_be_able_to_book_Hotel_Room() throws Throwable {
		confirmbookingpage=new ConfirmBookingPage();
	    String confirmMessage=confirmbookingpage.getLabel();
	    Assert.assertEquals("Booking confirmation message", "Booking Completed!", confirmMessage);
	    System.out.println("User navigated to the success page and message displayed: "+confirmMessage);
	}
	
	@Then("^Close the Browser$")
	public void close_the_Browser() throws Throwable {
	    driver.close();
	}
	
	@After
	public void afterScenario(Scenario scenario) throws IOException {
		Reporter.addScenarioLog("In case of failure takes screenshot");
		if(scenario.isFailed()) {
			String screenshotname=scenario.getName().replaceAll(" ", "_");
			TakesScreenshot screen=(TakesScreenshot)driver;
			File srcPath=screen.getScreenshotAs(OutputType.FILE);
			File destPath=new File(System.getProperty("user.dir")+"//target//html//"+screenshotname+".png");
			FileUtils.copyFile(srcPath,destPath);
			Reporter.addScreenCaptureFromPath(destPath.toString());
		}
	}
}
