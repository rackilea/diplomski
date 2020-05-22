import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class ExcelWriteXLTX {

 public static void main(String[] args) throws Exception {

  try (Workbook workbook = new XSSFWorkbook(); 
       FileOutputStream fileout = new FileOutputStream("ExcelTemplate.xltx") ) {

   Sheet sheet = workbook.createSheet();
   Cell cell = sheet.createRow(0).createCell(0);
   cell.setCellValue("Content in template");
   // ...

   ((XSSFWorkbook)workbook).getPackagePart().setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.template.main+xml");
   workbook.write(fileout);
  }

 }
}