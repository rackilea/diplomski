import java.io.*;
import org.apache.poi.xwpf.usermodel.*;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

import org.apache.xmlbeans.XmlCursor;
import java.math.BigInteger;

public class CreateWordHeaderFooterTable {

 public static void main(String[] args) throws Exception {

  XWPFDocument doc= new XWPFDocument();

  // the body content
  XWPFParagraph paragraph = doc.createParagraph();
  XWPFRun run=paragraph.createRun();  
  run.setText("The Body:");

  paragraph = doc.createParagraph();
  run=paragraph.createRun();  
  run.setText("Lorem ipsum....");

  // create header-footer
  CTSectPr sectPr = doc.getDocument().getBody().addNewSectPr();
  XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(doc, sectPr);

  // create header start
  XWPFHeader header = headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);

  paragraph = header.getParagraphArray(0);
  if (paragraph == null) paragraph = header.createParagraph();
  paragraph.setAlignment(ParagraphAlignment.LEFT);

  run = paragraph.createRun();  
  run.setText("The Header:");

  // create table in header
  paragraph = header.createParagraph();
  XmlCursor cursor = paragraph.getCTP().newCursor();
  XWPFTable table = header.insertNewTbl(cursor);
  XWPFTableRow row = table.getRow(0); if (row == null) row = table.createRow();
  int twipsPerInch =  1440;
  table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(6 * twipsPerInch));
  for (int i = 0; i < 3; i++) {
   XWPFTableCell cell = row.getCell(i); if (cell == null) cell = row.createCell();
   CTTblWidth tblWidth = cell.getCTTc().addNewTcPr().addNewTcW();
   tblWidth.setW(BigInteger.valueOf(2 * twipsPerInch));
   tblWidth.setType(STTblWidth.DXA);
   paragraph = cell.getParagraphs().get(0);
   run = paragraph.createRun();
   run.setText("Header Table Cell " + i);
  }

  // create footer start
  XWPFFooter footer = headerFooterPolicy.createFooter(XWPFHeaderFooterPolicy.DEFAULT);

  paragraph = footer.getParagraphArray(0);
  if (paragraph == null) paragraph = footer.createParagraph();
  paragraph.setAlignment(ParagraphAlignment.CENTER);

  run = paragraph.createRun();  
  run.setText("The Footer:");

  doc.write(new FileOutputStream("CreateWordHeaderFooterTable.docx"));

 }
}