package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class HomePage extends SeleniumUtility {

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(xpath="//span[text()='PIM']")
	private WebElement pimLink;
	
	public void clickOnPIM() {
		clickOnElement(pimLink);
	}
}
