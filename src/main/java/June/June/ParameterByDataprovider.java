package June.June;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterByDataprovider {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Sheetal\\drv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://google.com");
	}

	/**
	 * Test case to verify google search box
	 * 
	 * @param author
	 * @param searchKey
	 * @throws InterruptedException
	 */

	@Test(dataProvider = "SearchProvider")
	public void testMethod(String author, String searchKey, String text) throws InterruptedException {
		{
			WebElement searchText = driver.findElement(By.name("q"));
			// search value in google searchbox
			searchText.sendKeys(searchKey);
			System.out.println("Welcome ->" + author + " Your search key is->" + searchKey + " and text is: " + text);
			Thread.sleep(3000);
			String testValue = searchText.getAttribute("value");
			System.out.println(testValue + "::::" + searchKey);
			searchText.clear();
			// Verify if the value in google search box is correct
			Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
		}
	}

	/**
	 * @return Object[][] where first column contains 'author' and second column
	 *         contains 'searchKey'
	 */

	@DataProvider(name = "SearchProvider")
	// public object [][] getDataFromDataprovider (){
	public Object[][] getData() {
		return new Object[][] {
			{ "Guru99", "India", "a" },
			{ "Krishna", "UK", "b" },
			{ "Bhupesh", "USA", "C" } };
	}

	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
