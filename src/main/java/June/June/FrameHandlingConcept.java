package June.June;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FrameHandlingConcept {

	@Test
	public void frameHandling() {
		System.setProperty("webdriver.chrome.driver", "D:\\Sheetal\\drv\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.softwaretestinghelp.com/");

		driver.manage().window().maximize();

		// Here we are switching into the frame by using the frame Element....
		// otherwise we can switch by using id,name and index of the frame
		WebElement frameWebElement = driver.findElement(By.xpath("//iframe[@id='aswift_0']"));

		driver.switchTo().frame(frameWebElement);

		System.out.println("Frame Source: " + driver.getPageSource());

		// This method will move the content from frame to page.
		driver.switchTo().defaultContent();

		driver.quit();
	}
}
