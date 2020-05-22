import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.CellType.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;

import java.util.List;
import java.util.ArrayList;

class ReadExcelRichTextCells {

 public static void main(String[] args) throws Exception {

  Workbook wb  = WorkbookFactory.create(new FileInputStream("ExcelRichTextCells.xlsx"));

  Sheet sheet = wb.getSheetAt(0);
  for (Row row : sheet) {
   for (Cell cell : row) {

    switch (cell.getCellTypeEnum()) {
     case STRING:
      XSSFRichTextString richtextstring = (XSSFRichTextString)cell.getRichStringCellValue();
      String textstring = richtextstring.getString();

      List<String> textparts = new ArrayList<String>();

      if (richtextstring.hasFormatting()) {
       for (int i = 0; i < richtextstring.numFormattingRuns(); i++) {

        if (richtextstring.getFontOfFormattingRun(i)==null || !richtextstring.getFontOfFormattingRun(i).getStrikeout()) {

         int indexofformattingrun = richtextstring.getIndexOfFormattingRun(i);
         String textpart = textstring.substring(indexofformattingrun, 
                                                indexofformattingrun + richtextstring.getLengthOfFormattingRun(i));
         String[] textpart_split = textpart.split("-");
         for (int j = 0; j < textpart_split.length; j++){
          String text = textpart_split[j].replace("\n", "").trim();       
          if (!"".equals(text)) textparts.add(text);
         }
        }
       } 
      } else {
       textparts.add(textstring);
      }

      System.out.println(textparts);
      break;

     //...
     default:
      System.out.println("default cell"); //should never occur
    }
   }
  }

  wb.close();

 }
}