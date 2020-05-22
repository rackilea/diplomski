import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

class CreateExcelVerticalAlignment {

 public static void main(String[] args) throws Exception {

//  try (Workbook workbook = new XSSFWorkbook(); 
//       FileOutputStream fileout = new FileOutputStream("Excel.xlsx") ) {

  try (Workbook workbook = new HSSFWorkbook(); 
       FileOutputStream fileout = new FileOutputStream("Excel.xls") ) {

   CellStyle headerCellStyle = workbook.createCellStyle();
   headerCellStyle = workbook.createCellStyle();
   headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

   Sheet sheet = workbook.createSheet();
   sheet.setColumnWidth(0, 20*256);
   Row row = sheet.createRow(0);
   row.setHeightInPoints(40);
   Cell cell = row.createCell(0);
   cell.setCellStyle(headerCellStyle);
   cell.setCellValue("1082192560 1868");

   workbook.write(fileout);
  }

 }
}