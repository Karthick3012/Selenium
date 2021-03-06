package week2.day2;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/radio.html");
		
		driver.findElement(By.id("yes")).click();
		
		List<WebElement> checked = driver.findElements(By.xpath("//input[@name='news']"));
		int size = checked.size();
		for (int i = 0; i < size; i++) {
			if (checked.get(i).isSelected()) {
				System.out.println("Radio Button " + i + " is selected by default");
				
			}
		}
		WebElement agegroup = driver.findElement(By.xpath("//input[@name='age'][2]"));
		boolean selected = agegroup.isSelected();
		if (!selected) {
			agegroup.click();
		} else {
			System.out.println("Age group 21 - 40 years is already selected");
		}
	}

}