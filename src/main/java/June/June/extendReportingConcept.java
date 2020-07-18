package June.June;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class extendReportingConcept {

	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Sheetal\\drv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.browserstack.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// initialize report
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
	}

	@BeforeMethod
	public void startTest(Method method) {
		// 'startTest' is precondition of the test case or test method
		test = report.startTest(method.getName());

	}

	@Test(priority = 0)
	public void testOne() {
		System.out.println("This is first Test");
		test.log(LogStatus.INFO, "This is Test One.... info");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
		if (actualTitle.contentEquals(expectedTitle)) {
			test.log(LogStatus.PASS, "Title is matched successfully... Test ONE");
		} else {
			test.log(LogStatus.FAIL, "Failed to match the title..... Test ONE");
		}

		// The flush method is used to erase any previous data on a relevant
		// report and create a whole new report.
		report.flush();
	}

	@Test(priority = 1)
	public void testTwo() {
		System.out.println("This is second test");
		test.log(LogStatus.INFO, "This is Test Second..... ");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Most Reliable App & Cross Browser Testing Platform | ";
		if (actualTitle.equals(expectedTitle)) {
			test.log(LogStatus.PASS, "Title is matched successfully..... Test TWO");
		} else {
			test.log(LogStatus.FAIL, "Failed!!!! to match the title of the page.... Test TWO");

		}
		report.flush();
	}

	@Test(priority = 2)
	public void testThree() {
		test.log(LogStatus.INFO, "This is Test Three.... ");
		test.log(LogStatus.ERROR, "This is error logs...... ");
		report.flush();
	}

	@Test(priority = 3)
	public void testFour() {
		test.log(LogStatus.INFO, "This is Test Four");
		test.log(LogStatus.WARNING, "This is warning logs..... ");
		report.flush();
	}

	@Test(priority = 4)
	public void testFive() {
		test.log(LogStatus.INFO, "This is Test Five");
		test.log(LogStatus.FATAL, "This is fatal logs.... ");
		report.flush();
	}

	@Test(priority = 5)
	public void testSix() {
		test.log(LogStatus.INFO, "This is Test Six");
		test.log(LogStatus.SKIP, "This is skip logs....");
	}

	@AfterMethod
	public void endTest() {
		// 'endTest' is post condition of the testcase or test method
		report.endTest(test);
	}

	@AfterTest
	public void driverQuit() {
		driver.quit();
	}

}
