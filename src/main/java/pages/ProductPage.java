package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage extends BasePage {

	WebDriver driver;
	double DblCurrentTotal;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//input[@id='quantitywanted']")
	WebElement QuantityWanted;
	@FindBy(how = How.XPATH, using = "//select[@id='group1']")
	WebElement SizeSelection;
	@FindBy(how = How.XPATH, using = "//a[@id='color14']")
	WebElement SelectColor;
	@FindBy(how = How.XPATH, using = "//p[@id='addtocart']/button")
	WebElement AddToCartButton;
	@FindBy(how = How.XPATH, using = "//*[@id='layercart']/div[1]/div[2]/div[4]/a")
	WebElement ProceedToCheckoutButton;
	@FindBy(how = How.XPATH, using = "//a[@class='cartquantityup btn btn-default button-plus']")
	WebElement IncreaseQuantityButton;
	@FindBy(how = How.XPATH, using = "//td[@class='carttotal']//span")
	WebElement TotalProductPrice;
	@FindBy(how = How.XPATH, using = "//td[@data-title='Unit price']//span//span")
	WebElement ProductPrice;

	// InteractiveMethods
	public void enterQuantity(String quantity) {
		QuantityWanted.clear();
		QuantityWanted.sendKeys(quantity);
	}

	public void selectSize(String Size) {
		selectFromDropdownByVisibleText(SizeSelection, Size);
	}

	public void selectColor() {
		SelectColor.click();
	}

	public void clickAddToCartButton() {
		AddToCartButton.click();
	}

	public void clickProceedToCheckoutButton() {
		ProceedToCheckoutButton.click();
	}

	public void clickIncreaseQuantityButton() {
		IncreaseQuantityButton.click();
	}

	public void testTotalCalculation() throws InterruptedException {

		double dblCurrentTotal = convertStringToDouble(TotalProductPrice);
		
		clickIncreaseQuantityButton();
		
		double dblProductPrc = convertStringToDouble(ProductPrice);

		Thread.sleep(2000);

		double dblModifiedTotal = convertStringToDouble(TotalProductPrice);
		
		if (dblCurrentTotal + dblProductPrc == dblModifiedTotal) {
			System.out.println("Success! the calculation is correct");
		} else {
			System.out.println("Failure, the calculation is wrong");
		}
	}

}
