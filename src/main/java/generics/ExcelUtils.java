package generics;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {
    XSSFSheet sheet;
    public ExcelUtils(String excelPath, String sheetName) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRowCount() {
        int rowCount = sheet.getPhysicalNumberOfRows();
        return rowCount;
    }

    public int getColCount() {
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        return colCount;
    }

    public String getCellData(int rowNum, int colNum) {
        String cellData = sheet.getRow(rowNum).getCell(colNum).toString();
        return cellData;
    }
    /*
    public double getCellDataNumber(int rowNum, int colNum) {
        Double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
        return cellData;
    }*/
}
