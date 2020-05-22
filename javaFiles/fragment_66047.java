import java.io.FileOutputStream;
import java.io.FileReader;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opencsv.CSVReader;

class ParseCSVToExcel {

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

   CSVReader reader = new CSVReader(in);
   String [] nextLine;
   while ((nextLine = reader.readNext()) != null) {
    row = sheet.createRow(r++);
    int c = 0;
    for (String field : nextLine) {
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