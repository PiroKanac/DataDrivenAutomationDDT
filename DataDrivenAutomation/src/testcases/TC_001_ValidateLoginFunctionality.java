package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.DriverInstance;
import datagenerators.DataGenerator;
import pages.LoginPage;

//************Update test case with Data Provider (data driven : static data)***************
/*public class TC_001_ValidateLoginFunctionality extends DriverInstance {
	
	@Test(dataProvider="Static")
	public void tc_001_login(String uname, String pass) throws Exception 
	{
		LoginPage login = new LoginPage(driver);
		login.enterUsername(uname);
		login.enterPassword(pass);
		login.clickSigninButton();
	}
	
	@DataProvider(name="Static")
	public Object[][] testDataGenerator()
	{
		Object [][] data = {{"Unam1","Pass"},{"Unam2","Pass2"},{"Unam3","Pass3"}};
		return data;
	} */


//************Update test case with data driven : dynamic data from excel***************
public class TC_001_ValidateLoginFunctionality extends DriverInstance {
	
	@Test(dataProvider ="Excel", dataProviderClass=DataGenerator.class)
	public void tc_001_login(String uname, String pass) throws Exception 
	{
		LoginPage login = new LoginPage(driver);
		login.enterUsername(uname);
		login.enterPassword(pass);
		login.clickSigninButton();
	}
	
	/*@DataProvider(name="Excel")
	public Object[][] testDataGenerator() throws Exception
	{
		FileInputStream file = new FileInputStream("./TestData/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet loginSheet = workbook.getSheet("Login");
		int numberOfData = loginSheet.getPhysicalNumberOfRows();
		Object [][] testData = new Object[numberOfData][2];
		
		for(int i = 0; i < numberOfData; i++)
		{
			XSSFRow row = loginSheet.getRow(i);
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);
			testData[i][0] = username.getStringCellValue();
			testData[i][1] = password.getStringCellValue();
		}
		return testData;
	}*/
	
	
	
}
