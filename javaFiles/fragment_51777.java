import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class ReadAndWriteRichText {

 private static boolean isNumeric(String string) {
  try {  
   double d = Double.parseDouble(string);  
  } catch(NumberFormatException nfe) {  
   return false;  
  }  
  return true;  
 }

 private static RichTextString formatNumbersOfCellText(String outputString, Font numberFont, Font strFont) {

  RichTextString richString = new HSSFRichTextString(outputString);

  String[] tokens = outputString.split("\\s"); // splits on a single space, so possibly empty strings are in the array

  int start = 0;
  int end = 0;
  for (int i = 0; i < tokens.length; i++) {
   String token = tokens[i];
   end = start + token.length();

   if (i < tokens.length - 1) {
    end = end + 1; // if not the last token, then take one character more than the length because of formatting the split-delimiter-space after the token
   }

   if (isNumeric(token)) {
    richString.applyFont(start, end, numberFont);
   } else {
    richString.applyFont(start, end, strFont);
   }
   start = end;
  }

  return richString;
 }

 public static void main(String[] args) {
  try {

   InputStream inp = new FileInputStream("Source.xls");
   Workbook wb = WorkbookFactory.create(inp);

   Font font1 = wb.createFont();
   font1.setFontName("Arial");
   font1.setFontHeightInPoints((short)26);

   Font font2 = wb.createFont();
   font2.setFontName("Terminal");
   font2.setFontHeightInPoints((short)26);

   Sheet sheet = wb.getSheetAt(0);

   for (Row row : sheet) {
    for (Cell cell : row) {
     String cellValue = cell.getStringCellValue(); // all cells must be text cells
     RichTextString richString = formatNumbersOfCellText(cellValue, font2, font1);
     cell.setCellValue(richString);
    }
   }

   FileOutputStream fileOut = new FileOutputStream("Target.xls");
   wb.write(fileOut);
   wb.close();

  } catch (Exception ex) {
    ex.printStackTrace();
  }
 }
}