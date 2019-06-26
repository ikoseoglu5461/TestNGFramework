package com.syntax.practice;

import org.testng.annotations.Test;

import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;


public class ExcelFunctionTest {

	
	@Test
	public void excelTest() {
		
		ExcelUtility obj=new ExcelUtility();
		obj.openExcel(Constants.XL_FILEPATH, "EmployeeDetails");
		//String value = obj.getCellData(2, 3);
		//System.out.println(value);
		
		//retrieve all values from excell and store intoDataProvider (2D Object array)
		
		int row=obj.getRowNum();
		int cell=obj.getColNum(0);
		
		Object [] [] data=new Object [row][cell];
		//loop through each row % columns
		for (int i=0; i<row; i++) {
			cell=obj.getColNum(i);
			for (int y=0; y<cell; y++) {
				//retrieve value from excel
				String value=obj.getCellData(i, y);
				//store inside 2D array
				data[i][y]=value;
				
			}
		}
		System.out.println(data.length);
	}
}