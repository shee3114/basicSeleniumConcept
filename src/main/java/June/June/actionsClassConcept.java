package June.June;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class actionsClassConcept {

	@Test
	public void clickButton() {

		System.setProperty("webdriver.chrome.driver", "D:\\Sheetal\\drv\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.browserstack.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Intialise actions class
		Actions actions = new Actions(driver);

		WebElement button = driver.findElement(By.xpath("//a[@id='signupModalButton']"));

		// Generate the actions sequence
		 actions.click(button);

		// Build actions sequence
		Action action = actions.build();

		// Perform action sequence.
		 action.perform();

		// We can do line no 30, 33 and 36 in one line as below
		//actions.click(button).perform();
		
	}

}
