import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*; 
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelAllColumnsFitToOnePageWidth {

 public static void main(String[] args) throws Exception {
  //Workbook workbook = new HSSFWorkbook();
  Workbook workbook = new XSSFWorkbook();
  Sheet sheet = workbook.createSheet();

  for (int r = 0; r < 200; r++) {
   Row row = sheet.createRow(r);
   for (int c = 0; c < 16; c++) {
    Cell cell = row.createCell(c);
    cell.setCellValue("Lorem ipsum");
    if (r==0) sheet.autoSizeColumn(c);
   }
  }

  sheet.setAutobreaks(true);
  sheet.setFitToPage(true);
  PrintSetup printSetup = sheet.getPrintSetup();
  printSetup.setFitHeight((short)0);
  printSetup.setFitWidth((short)1);


  String fileout = (workbook instanceof HSSFWorkbook)?"Excel.xls":"Excel.xlsx";
  FileOutputStream out = new FileOutputStream(fileout);
  workbook.write(out);
  out.close();
 }
}