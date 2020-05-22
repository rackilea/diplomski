import java.io.FileOutputStream;
import java.io.FileReader;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVFormat;

class ParseCSVToExcelApacheCommonsCSV {

 public static void main(String[] args) throws Exception {

  try (XSSFWorkbook workbook = new XSSFWorkbook(); 
       FileOutputStream out = new FileOutputStream("Excel.xlsx");
       FileReader in = new FileReader("CSV.csv")) { 

   CellStyle cellStyle = workbook.createCellStyle();
   cellStyle.setWrapText(true);

   Sheet sheet = workbook.createSheet("FromCSV");
   Row row = null;
   Cell cell = null;
   int r = 0;
   int maxC = 0;

   for (CSVRecord record : CSVFormat.RFC4180.parse(in)) {
    row = sheet.createRow(r++);
    int c = 0;
    for (String field : record) {
     cell = row.createCell(c++);
     cell.setCellValue(field);
     cell.setCellStyle(cellStyle);
    }
    if (c > maxC) maxC = c;
   }

   for (int c = 0; c < maxC; c++) {
    sheet.autoSizeColumn(c);
   }

   workbook.write(out);

  }
 }
}