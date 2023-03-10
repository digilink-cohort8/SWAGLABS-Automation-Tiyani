package utility;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.time.Duration;

public class ExcelUtil {
    public static FileInputStream Fis;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;


//    public static  int getRowCount(String xlsxFilePath, String xlsxSheet) throws IOException {
//        Fis = new FileInputStream(xlsxFilePath);
//        workbook = new XSSFWorkbook(Fis);
//        sheet = workbook.getSheet(xlsxSheet);
//        int rowCount = sheet.getLastRowNum();
//        workbook.close();
//        Fis.close();
//        return rowCount;
//    }

//    public static int getCellCount(String xlsxFilePath, String xlsxSheet, int rowNum) throws IOException {
//        Fis = new FileInputStream(xlsxFilePath);
//        workbook = new XSSFWorkbook(Fis);
//        sheet = workbook.getSheet(xlsxSheet);
//        row = sheet.getRow(rowNum);
//        int cellCount = row.getLastCellNum();
//        workbook.close();
//        Fis.close();
//        return cellCount;
//    }

    public static String getCellData(File xlsxFilePath, String xlsxSheet, int rowNum, int colNum) throws IOException {
        Fis = new FileInputStream(xlsxFilePath);
        workbook = new XSSFWorkbook(Fis);
        sheet = workbook.getSheet(xlsxSheet);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);

        String data;

        try{
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
            return data;
        }
        catch (Exception e){
            data = "";
        }
        workbook.close();
        Fis.close();
        return data;
    }
    public static File file_setup(){
        File file;
        file = new File(System.getProperty("user.dir")+"/src/main/resources/data/data.xlsx");
        return  file;
    }

}
