import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;

import java.util.Random;

public class CreateWordTableKeepTogether {

 public static void main(String[] args) throws Exception {

  int numtables = 5;
  int numrows;
  Random random = new Random();
  int numcols = 5;

  XWPFDocument document = new XWPFDocument();

  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run = paragraph.createRun();
  run.setText("The tables:");

  for (int t = 0; t < numtables; t++) {

   numrows = random.nextInt(10) + 3;

   paragraph = document.createParagraph();
   run = paragraph.createRun();
   run.setText("Table " + (t+1));

   //don't split the paragraph itself
   paragraph.getCTP().addNewPPr().addNewKeepLines().setVal(STOnOff.ON);
   //keep this paragraph together with the next paragraph
   paragraph.getCTP().getPPr().addNewKeepNext().setVal(STOnOff.ON);

   XWPFTable table = document.createTable();

   for (int r = 0; r < numrows; r++) {
    XWPFTableRow row = table.getRow(r);
    if (row == null) row = table.createRow();

    //don't divide this row
    row.setCantSplitRow(true);

    for (int c = 0; c < numcols; c++) {
     XWPFTableCell cell = row.getCell(c);
     if (cell == null) cell = row.createCell();
     paragraph = cell.getParagraphArray(0);
     if (paragraph == null) paragraph = cell.addParagraph();
     run = paragraph.createRun();
     run.setText("T" + (t+1) + "R" + (r+1) + "C" + (c+1));

     if (c == 0) { //only necessary for column one, since further columns in this row are protected by setCantSplitRow
      paragraph.getCTP().addNewPPr().addNewKeepLines().setVal(STOnOff.ON);
      paragraph.getCTP().getPPr().addNewKeepNext().setVal(STOnOff.ON);
     }

    }  
   }

   //this is necessary, since it is the only paragraph which allows page breaks
   paragraph = document.createParagraph();

  }

  document.write(new FileOutputStream("CreateWordTableKeepTogether.docx"));
  document.close();

 }
}