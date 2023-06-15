package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TshirtsPage {
	
	WebDriver driver;
	
	public TshirtsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	@FindBy(how = How.XPATH, using = "//*[@id=\"centercolumn\"]/ul/li/div/div[2]/div[2]/a[2]/span")WebElement moreButtonProductOne;
	@FindBy(how = How.XPATH, using = "//*[@id=\"centercolumn\"]/ul/li/div/div[1]/div/a[1]/img")WebElement productImage;
	@FindBy(how = How.XPATH, using = "//a[@class='addToWishlist wishlistProd1']")WebElement wishlistProduct;
	@FindBy(how = How.XPATH, using = "//p[@class='fancybox-error']")WebElement wishlistErrorBox;
	
	//InteractiveMethods
	public void hoverOverProduct() {
		Actions actions = new Actions(driver);
		actions.moveToElement(productImage).perform();
	}
	
	public void clickMoreButtonProductOne() {
		moreButtonProductOne.click();
	}
	
	public void clickWishListProduct() {
		wishlistProduct.click();
	}
	
	public void verifyWishListErrorBox() {
		
		Logger logger = LoggerFactory.getLogger(TshirtsPage.class);
		if(wishlistErrorBox.getText().contains("You must be logged in to manage your wishlist.")) {
			logger.info("Success! Error message displayed");
		}else {
			logger.info("Failure, Error message didn't display");
		}
	}

}
