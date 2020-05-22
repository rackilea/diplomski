import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class ReadAndWriteRichText {

 public static void main(String[] args) {
  try {

   InputStream inp = new FileInputStream("Source.xls");
   Workbook wb = WorkbookFactory.create(inp);

   Sheet sheet = wb.getSheetAt(0);
   Row row = sheet.getRow(0);
   Cell cell = row.getCell(0);

   Font font1 = wb.getFontAt(cell.getCellStyle().getFontIndex());
   System.out.println(font1);

   Font font2 = wb.createFont();
   font2.setFontName("Terminal");
   font2.setFontHeightInPoints(font1.getFontHeightInPoints());
   System.out.println(font2);

   RichTextString richString = new HSSFRichTextString( "SS 123 SS" );
                                                      //^0 ^3 ^6 ^9
   richString.applyFont( 0, 3, font1 );
   richString.applyFont( 3, 6, font2 );
   richString.applyFont( 6, 9, font1 );
   cell.setCellValue( richString );

   FileOutputStream fileOut = new FileOutputStream("Target.xls");
   wb.write(fileOut);
   wb.close();

  } catch (Exception ex) {
  }
 }
}