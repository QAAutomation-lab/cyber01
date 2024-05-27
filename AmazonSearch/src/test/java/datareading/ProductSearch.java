package datareading;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
import utilities.SeleniumUtility;

public class ProductSearch extends SeleniumUtility{
	
	WebDriver driver;
	static String productPrice=null;
	ExcelUtility getExcelUtility=null;
	static String filePath=".\\src\\test\\resources\\test-data\\Product_Details.xlsx";
	static int productNumber=0;
	
	@BeforeMethod
	public void precondition() {		
		driver=setUp("chrome", "https://www.amazon.in");
	}
	@Test(dataProvider="ProductName",dataProviderClass=DataProviders.class)
	public void testSeachProduct(String productName)
	{
		System.out.println(productName);
		typeInput(driver.findElement(By.id("twotabsearchtextbox")), productName);
		getActiveElementFromUI().sendKeys(Keys.ENTER);
		setSleepTime(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-price-whole']")));
		productPrice=getTextFromElement(driver.findElement(By.xpath("//span[@class='a-price-whole']")));
		productNumber++;
	}
	
	@AfterMethod
	public void postCondition() {
		getExcelUtility=new ExcelUtility(filePath);
		getExcelUtility.setCellData("sheet1", productNumber, 1, productPrice);
		driver.close();
	}

}
