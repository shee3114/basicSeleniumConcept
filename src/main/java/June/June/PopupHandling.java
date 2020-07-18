package June.June;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PopupHandling {
	@Test
	public void popUpHandling() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\drv\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		// Handle simple alert
		WebElement alertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		alertButton.click();
		Thread.sleep(2000);

		// Check if the alert notification is showing or not
		driver.switchTo().alert();

		String simpleAlertMessage = driver.switchTo().alert().getText();
		System.out.println(simpleAlertMessage);
		if (simpleAlertMessage.contains("I am a JS Alert")) {
			// accept the alert
			driver.switchTo().alert().accept();
			System.out.println("Successfully click on OK button on simple alert pop-up.");
		} else {
			System.out.println("Test is Failed");
		}

		Thread.sleep(3000);

		// handle confirmation alert
		WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
		confirmationAlertButton.click();
		Thread.sleep(3000);

		driver.switchTo().alert();
		String cofirmationAlertMessage = driver.switchTo().alert().getText();
		System.out.println(cofirmationAlertMessage);
		if (cofirmationAlertMessage.contains("I am a JS Confirm")) {
			// accept the alert
			driver.switchTo().alert().dismiss();
			System.out.println("Successfully click on Cancel button on confirmation alert pop-up.");
		} else {
			System.out.println("Test is Failed");
		}

		// Handle prompt alert
		WebElement promptAlertButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		promptAlertButton.click();
		Thread.sleep(3000);
		driver.switchTo().alert();
		String promptAlertMessage = driver.switchTo().alert().getText();
		System.out.println(promptAlertMessage);
		if (promptAlertMessage.contains("I am a JS prompt")) {
			// accept the alert
			Alert promptAlert = driver.switchTo().alert();
			promptAlert.sendKeys("Sheetal");
			driver.switchTo().alert().accept();
			WebElement messagePath = driver.findElement(By.xpath("//p"));
			String message = messagePath.getText();
			if (message.contains("You entered: Sheetal"))
				;
			{
				System.out.println(
						"Successfully the text is written in the text field and click on accept button on prompt alert pop-up.");
			}
		} else {
			System.out.println("Test is Failed");
		}

		driver.quit();
	}

}
