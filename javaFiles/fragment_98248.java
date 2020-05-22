import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

class CreateExcelBoldWord {

 public static void main(String[] args) throws Exception {

  Workbook workbook = new XSSFWorkbook(); 
  //Workbook workbook = new HSSFWorkbook();

  String fileName = (workbook instanceof XSSFWorkbook)?"Excel.xlsx":"Excel.xls";

  CreationHelper creationHelper = workbook.getCreationHelper();

  Font font = workbook.createFont(); // default font
  Font fontBold = workbook.createFont();
  fontBold.setBold(true);

  String text = "HellomynameisThad";
  String word = "name";

  RichTextString richTextString = creationHelper.createRichTextString(text);
  int startIndex = text.indexOf(word);
  int endIndex = startIndex + word.length();
  richTextString.applyFont(startIndex, endIndex, fontBold);

  Sheet sheet = workbook.createSheet();
  sheet.createRow(0).createCell(0).setCellValue(richTextString);

  FileOutputStream out = new FileOutputStream(fileName);
  workbook.write(out);
  out.close();
  workbook.close();
 }
}