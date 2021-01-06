package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BookHotelBase;

public class ConfirmBookingPage extends BookHotelBase{

	@FindBy(xpath="//h1")
	WebElement labelBookingCompleted;
	
	public ConfirmBookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getLabel() {
		String heading=labelBookingCompleted.getText();
		return heading;
	}
	
}
