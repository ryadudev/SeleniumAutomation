package radioButtonAndCheckBoxes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxDemo {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		boolean checkBox = driver.findElement(By.id("sunday")).isSelected();
		if (checkBox == false) {
			driver.findElement(By.id("sunday")).click();

		} else {
			System.out.println("checkbox selected");
		}

		// Find how many checkboxes are available in webpage.

		List<WebElement> checkboxesCount = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		System.out.println(checkboxesCount.size());
		
		/*
		 * For-each
		 */
		for (WebElement chbx : checkboxesCount) {

			chbx.click();
			
		}
		
		/*
		 * For loop.
		 */
		
	for(int i =0; i<checkboxesCount.size(); i++) {
		checkboxesCount.get(i).click();
		
	}
	
	/*
	 * Switch
	 */
	String weekName = "Sunday";
	switch(weekName) {
	case "Sunday" : driver.findElement(By.xpath("Checkbox xpath")).click();
	break;
	
	}

		
		

	}

}
