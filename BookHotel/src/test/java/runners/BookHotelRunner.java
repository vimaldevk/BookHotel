package runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src//test//resources//feature//",
		glue= {"stepdefs"},
		dryRun = false,
		strict= true,
		monochrome = true,
		plugin= {
				"com.cucumber.listener.ExtentCucumberFormatter:testOutput/ExtentReport.html"
				}
		)


public class BookHotelRunner {

	@AfterClass
	public static void writeExtentReport() {
	Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"//src//test//resources//extent-config.xml"));
		//Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));

		Reporter.setSystemInfo("User Name ", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone ", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Application Name ", "Sample Test App");
		Reporter.setSystemInfo("OS ", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment ", "Testing Server");
}
}
