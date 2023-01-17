package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class PimPage extends SeleniumUtility {

	public PimPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(css=".orangehrm-header-container>button")
	private WebElement addButton;
	
	@FindBy(xpath="//div[div[label[text()='Employee Id']]]/div[2]/input")
	private WebElement employeeIdInputField;
	
	@FindBy(css=".oxd-button--secondary.orangehrm-left-space")
	private WebElement searchButtonOnPimPage;
	
	@FindBy(css=".orangehrm-vertical-padding>span")
	private WebElement searchResultCountMsg;
	
	@FindBy(css=".oxd-table-body>div:nth-child(1) label>input")
	private WebElement firstCheckBox;
	
	@FindBy(css=".oxd-table-body>div:nth-child(1) .bi-pencil-fill")
	private WebElement editSymbol;
	
	@FindBy(css=".oxd-table-body>div:nth-child(1) .bi-trash")
	private WebElement deleteSymbol;
	
}

