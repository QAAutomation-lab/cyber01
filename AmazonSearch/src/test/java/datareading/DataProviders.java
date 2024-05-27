package datareading;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtility;

public class DataProviders {
	
	public static String path=".\\src\\test\\resources\\test-data\\Product_Details.xlsx";
	
	@DataProvider(name="ProductName")
	public String[] getProductName() {
		ExcelUtility xl=new ExcelUtility(path);
		int rowNum=xl.getRowCount("sheet1");
		
		String data[]=new String[rowNum];
		for(int i=1;i<=rowNum;i++) {
			data[i-1]=xl.getCellData("sheet1", i, 0);
		}
		return data;
	}
}