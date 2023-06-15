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
	@FindBy(how = How.XPATH, using = "//input[@id='quantity_wanted']")
	WebElement Quantity_Wanted;
	@FindBy(how = How.XPATH, using = "//select[@id='group_1']")
	WebElement Size_Selection;
	@FindBy(how = How.XPATH, using = "//a[@id='color_14']")
	WebElement Select_Color;
	@FindBy(how = How.XPATH, using = "//p[@id='add_to_cart']/button")
	WebElement AddToCart_Button;
	@FindBy(how = How.XPATH, using = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
	WebElement ProceedToCheckout_Button;
	@FindBy(how = How.XPATH, using = "//a[@class='cart_quantity_up btn btn-default button-plus']")
	WebElement IncreaseQuantity_Button;
	@FindBy(how = How.XPATH, using = "//td[@class='cart_total']//span")
	WebElement TotalProductPrice;
	@FindBy(how = How.XPATH, using = "//td[@data-title='Unit price']//span//span")
	WebElement ProductPrice;

	// InteractiveMethods
	public void enterQuantity(String quantity) {
		Quantity_Wanted.clear();
		Quantity_Wanted.sendKeys(quantity);
	}

	public void selectSize(String Size) {
		selectFromDropdownByVisibleText(Size_Selection, Size);
	}

	public void selectColor() {
		Select_Color.click();
	}

	public void clickAddToCartButton() {
		AddToCart_Button.click();
	}

	public void clickProceedToCheckoutButton() {
		ProceedToCheckout_Button.click();
	}

	public void clickIncreaseQuantityButton() {
		IncreaseQuantity_Button.click();
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
