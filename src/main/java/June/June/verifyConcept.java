package June.June;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class verifyConcept {

	WebDriver driver;
	SoftAssert softAssert;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Sheetal\\drv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.browserstack.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		softAssert = new SoftAssert();

	}

	/**
	 * The code below uses assertAll() to see assertion results at the end of
	 * the test
	 * softAssert.asertAll;
	 */
	@Test(priority = 0, enabled = true)
	public void checkVerifyConceptWithAssertEqual() {

		String actualTitle = driver.getTitle();
		String expectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStk";
		softAssert.assertEquals(actualTitle, expectedTitle);
		System.out.println("This is Test Case 1 for 'assertEqual'");
	}

	@Test(priority = 1, enabled = true)
	public void checkVerifyConceptWithAssertNoEqual() {

		String actualTitle = driver.getTitle();
		String expectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
		softAssert.assertNotEquals(actualTitle, expectedTitle);
		System.out.println("This is Test case 2 for 'assertNotEqual");
	}

	@Test(priority = 2, enabled = true)
	public void checkVerifyConceptWithAssertTrue() {
		String actualTitle = driver.getTitle();
		boolean verifyTitle = actualTitle.equals("Most Reliable App & Cross Browser Testing Platform | Browser");
		softAssert.assertTrue(verifyTitle);
		System.out.println("This is Test case 3 for 'asertTrue'");
	}

	@Test(priority = 3, enabled = true)
	public void checkVerifyConceptWithAssertFalse() {
		String actualTitle = driver.getTitle();
		boolean verifyTitle = actualTitle.equals("Most Reliable App & Cross Browser Testing Platform | BrowserStack");
		softAssert.assertFalse(verifyTitle);
		System.out.println("This is Test case 4 for 'assertFalse'");
	}

	@Test(priority = 4, enabled = true)
	public void checkVerifyConceptWithAssertNull() {
		String actualTitle = "Abc";
		softAssert.assertNull(actualTitle);
		System.out.println("This is Test Case 5 for 'assertNull'");
	}

	@Test(priority = 5, enabled = true)
	public void checkVerifyConceptWithAssertNotNull() {
		String actualTitle = null;
		softAssert.assertNotNull(actualTitle);
		System.out.println("This is Test Case 6 for 'assertNotNull'");
		// The code below uses assertAll() to see assertion results at the end
		// of the test
		softAssert.assertAll();

	}

	/**
	 * AssertTrue, assertFalse, assertEquals, assertNotEquals, assertNull,
	 * assertNotNull all are this are 'Hard assertion'
	 */

	/**
	 * softAssert.assertAll();
	 * 
	 * Verify in Selenium (also known as Soft Assertion) In a hard assertion,
	 * when the assertion fails, it terminates or aborts the test. If the tester
	 * does not want to terminate the script they cannot use hard assertions. To
	 * overcome this, one can use soft assertions.
	 */
	@AfterTest
	public void driverQuit() {
		driver.quit();
	}

}
