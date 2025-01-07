package alertsAndFrames;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Alerts are not web-elements
 */

public class AlertDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();

		/*
		 * Normal alert: alert with OK button
		 */
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Alert myAlert = driver.switchTo().alert();
		System.out.println(myAlert.getText());
		Thread.sleep(50);
		myAlert.accept();

		/*
		 * Confirmation alert : OK and CANCEL
		 */
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Alert myAlert1 = driver.switchTo().alert();
		System.out.println(myAlert1.getText());
//Confirm the alert : OK button
		myAlert1.accept();

		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Alert myAlert2 = driver.switchTo().alert();
		Thread.sleep(50);
//Dismissing the alert : CANCEL button
		myAlert2.dismiss();

		/*
		 * Alert with text box.
		 */
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Alert myAlert3 = driver.switchTo().alert();
		Thread.sleep(1000);
		myAlert3.sendKeys("Test");
		Thread.sleep(1000);
		myAlert3.accept();

	}

}
