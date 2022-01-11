package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) {

		try
		{
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
		
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

	public static void getCellData(int rowNum, int colNum) {
		
			DataFormatter formatter = new DataFormatter();
			
			Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
			//String value = sheet.getRow(1).getCell(0).getStringCellValue();
			System.out.println(value);
	}
	public static void getRowCount(){
		
//			String projDir = System.getProperty("user.dir");
//			System.out.println(projDir);
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of Rows: "+ rowCount);
	}
}
