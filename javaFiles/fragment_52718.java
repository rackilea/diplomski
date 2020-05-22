import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;

public class WordInsertTableRow {

 static XWPFTableRow insertNewTableRow(XWPFTableRow sourceTableRow, int pos) throws Exception {
  XWPFTable table = sourceTableRow.getTable();
  CTRow newCTRrow = CTRow.Factory.parse(sourceTableRow.getCtRow().newInputStream());
  XWPFTableRow tableRow = new XWPFTableRow(newCTRrow, table);
  table.addRow(tableRow, pos);
  return tableRow;
 }

 static void commitTableRows(XWPFTable table) {
  int rowNr = 0;
  for (XWPFTableRow tableRow : table.getRows()) {
   table.getCTTbl().setTrArray(rowNr++, tableRow.getCtRow());
  }
 }

 public static void main(String[] args) throws Exception {

  XWPFDocument doc = new XWPFDocument(new FileInputStream("source.docx"));
  boolean weMustCommitTableRows = false;

  XWPFTable table = doc.getTableArray(0);

  // insert new row, which is a copy of row 2, as new row 3:
  XWPFTableRow sourceTableRow = table.getRow(1);
  XWPFTableRow newRow3 = insertNewTableRow(sourceTableRow, 2);

  // now changing something in that new row:
  int i = 1;
  for (XWPFTableCell cell : newRow3.getTableCells()) {
   for (XWPFParagraph paragraph : cell.getParagraphs()) {
    for (XWPFRun run : paragraph.getRuns()) {
     run.setText("New row 3 run " + i++, 0);
    }
   }
  }
System.out.println(newRow3.getCtRow()); // was changed
System.out.println(table.getRow(2).getCtRow()); // even this is changed
System.out.println(table.getCTTbl().getTrArray(2)); // but this was not changed, why not?
  weMustCommitTableRows = true;

  if (weMustCommitTableRows) commitTableRows(table); // now it is changed

  FileOutputStream out = new FileOutputStream("result.docx");
  doc.write(out);
  out.close();
  doc.close();

 }
}