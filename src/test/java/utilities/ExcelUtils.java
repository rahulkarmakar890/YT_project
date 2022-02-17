package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	public static Workbook wb;
	public ExcelUtils(String excelpath) throws Throwable
	{
		FileInputStream fi = new FileInputStream(excelpath);
		wb = WorkbookFactory.create(fi);
	}
	
	//Row count
	public int getRowCount(String sheetname)
	{
		int lastRowNum = wb.getSheet(sheetname).getLastRowNum();
		return lastRowNum;
	}
	
	//Cell count
	public int getCellCount(String sheetname, int rownum)
	{
		int cellCount = wb.getSheet(sheetname).getRow(rownum).getLastCellNum();
		return cellCount;
	}
	
	//Read cell data
	public String getCelldata(String sheetname, int rownum, int cellnum)
	{
		String celldata = "";
		if(wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			int data = (int) wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getNumericCellValue();
			celldata = String.valueOf(data).trim();
		}
		else
		{
			celldata = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue().trim();
		}
		return celldata;
	}
	
	//Write cell data
	public void setCelldata(String sheetname, int rownum, int cellnum, String outputexcelpath, String status) throws Throwable
	{
		Sheet ws = wb.getSheet(sheetname);
		Row row = ws.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(status);
		FileOutputStream fo = new FileOutputStream(outputexcelpath);
		wb.write(fo);
		wb.close();
		fo.close();
	}

}
