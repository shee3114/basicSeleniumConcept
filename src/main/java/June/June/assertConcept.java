package June.June;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class assertConcept {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Sheetal\\drv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.browserstack.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 0, enabled = true)
	public void verifyAssertConceptWithAssertEqual() {

		String actualTitle = driver.getTitle();
		System.out.println("Actual Title: " + actualTitle);
		String expectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("This is Test Case 1 for 'assertEqual'");
		/*
		 * If the assertion condition is not met (the titles matching) then it
		 * will throw the “org.junit.ComparisonFailure” exception.
		 */
	}

	@Test(priority = 1, enabled = true)
	public void verifyAssertConceptWithAssertNoEqual() {

		String actualTitle = driver.getTitle();
		String expectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStk";
		Assert.assertNotEquals(actualTitle, expectedTitle);
		System.out.println("This is Test case 2 for 'assertNotEqual");
		/*
		 * If the assertion condition is not met (the titles matching) then it
		 * will throw the “org.junit.ComparisonFailure” exception.
		 */
	}

	@Test(priority = 2, enabled = true)
	public void verifyAssertConceptWithAssertTrue() {
		String actualTitle = driver.getTitle();
		boolean verifyTitle = actualTitle.equals("Most Reliable App & Cross Browser Testing Platform | BrowserStack");
		Assert.assertTrue(verifyTitle);
		System.out.println("This is Test case 3 for 'asertTrue'");
	}

	@Test(priority = 3, enabled = true)
	public void verifyAssertConceptWithAssertFalse() {
		String actualTitle = driver.getTitle();
		boolean verifyTitle = actualTitle.equals("Most Reliable App & Cross Browser Testing Platform | BrowserStk");
		Assert.assertFalse(verifyTitle);
		System.out.println("This is Test case 4 for 'assertFalse'");
		/*
		 * It retrieves the title from www.browserstack.com and the
		 * assertFalse() Method will verify the Boolean condition. If the
		 * Boolean value is “False” the condition is met and the test is marked
		 * as passed. If the condition is not met then it will throw the
		 * “java.lang.AssertionError” error.
		 */
	}

	@Test(priority = 4, enabled = true)
	public void verifyAssertConceptWithAssertNull() {
		String actualTitle = null;
		Assert.assertNull(actualTitle);
		System.out.println("This is Test Case 5 for 'assertNull'");
	}

	@Test(priority = 5, enabled = true)
	public void verifyAssertConceptWithAssertNotNull() {
		String actualTitle = driver.getTitle();
		Assert.assertNotNull(actualTitle);
		System.out.println("This is Test Case 6 for 'assertNotNull'");
	}

	/**
	 * AssertTrue, assertFalse, assertEquals, assertNotEquals, assertNull,
	 * assertNotNull all are this are 'Hard assertion'
	 */

	/**
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
