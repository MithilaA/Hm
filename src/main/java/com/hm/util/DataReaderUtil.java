package com.hm.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataReaderUtil {
	public static String DATA_SHEET_PATH = "C:\\Users\\mithilaa\\eclipse-workspace\\myworkspace\\Hm\\src\\main\\java\\com\\hm\\testdata\\Items.xlsx";
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file = null;
		Workbook book = null;
		Sheet sheet;
		
		try {
			file = new FileInputStream(DATA_SHEET_PATH);
		}catch(FileNotFoundException e )
		{
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	

}
