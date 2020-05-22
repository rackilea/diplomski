import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestExcelReader {
  public static void main(String[] args) throws Exception {
    FileInputStream file =
        new FileInputStream(
            new File(
                "Some Location in windows\\TestData_01.xlsx"));
    XSSFWorkbook workbook = new XSSFWorkbook(file);
    XSSFSheet sheet = workbook.getSheetAt(0);
    Iterator<Row> rowIterator = sheet.iterator();

    Map<String, ExcelFileData> excelDataMap = new LinkedHashMap<>();

    while (rowIterator.hasNext()) {
      Row row = rowIterator.next();
      Cell testCaseCell = row.getCell(0); // Test Case Name or Test Case Id

      Cell fileFormatCell = row.getCell(1);
      Cell filePathCell = row.getCell(2);

      ExcelFileData excelFileData = new ExcelFileData();
      if (fileFormatCell != null) excelFileData.setFileFormat(fileFormatCell.getStringCellValue());
      if (filePathCell != null) excelFileData.setFilePath(filePathCell.getStringCellValue());
      if (testCaseCell != null) {
        excelDataMap.put(testCaseCell.getStringCellValue(), excelFileData);
      }
    }

    excelDataMap.forEach(
        (key, value) -> {
          System.out.println("Key as test case Id : " + key);
          System.out.println("File Format : " + value.getFileFormat());
          System.out.println("File Path : " + value.getFilePath());
        });
  }
}