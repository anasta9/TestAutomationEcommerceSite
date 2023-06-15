package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public int randomNumberGenerator() {
		int randNum = (int) (Math.random() * 999 + 100);
		return randNum;
	}

	public int dateNumberGenerator() {
		int randNum = (int) (Math.random() * 31 + 1);
		return randNum;
	}

	public String phoneNumberGenerator() {
		int areaCode = (int) (Math.random() * 999 + 100);
		int firstThree = (int) (Math.random() * 999 + 100);
		int lastfour = (int) (Math.random() * 9999 + 1000);
		String phoneNum = areaCode + " " + firstThree + " " + lastfour;
		return phoneNum;
	}

	public void selectFromDropdownByVisibleText(WebElement element, String input) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(input);
	}

	public void selectFromDropdownByValue(WebElement element, String input) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(input);
	}

	public String removeDecimalPoint(String str) {
		return str.substring(0, str.length() - 2);
	}

	public double convertStringToDouble(WebElement element) {
		String stringElement = element.getText().substring(1);
		double doubleElement = Double.parseDouble(stringElement);
		return doubleElement;
	}

	public void waitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
