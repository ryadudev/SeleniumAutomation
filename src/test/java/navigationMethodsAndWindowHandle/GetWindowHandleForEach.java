package navigationMethodsAndWindowHandle;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetWindowHandleForEach {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		Set<String> WindowID = driver.getWindowHandles();

		for (String url : WindowID) {

			String title = driver.switchTo().window(url).getTitle(); // here we don't know to which window driver has
																		// switched

			if (title.equalsIgnoreCase("Human Resources Management Software | OrangeHRM")) {
				System.out.println("Child window");
				driver.findElement(By.xpath("//input[@name='EmailHomePage']")).sendKeys("abc@gmail.com");

			}

		}

		/*
		 * closing specific browser window : parent window
		 */

		for (String url1 : WindowID) {
			String title1 = driver.switchTo().window(url1).getTitle();
			if (title1.equalsIgnoreCase("OrangeHRM")) {
				driver.close();
			}

		}

	}
}