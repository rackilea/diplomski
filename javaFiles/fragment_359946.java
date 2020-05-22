import java.io.*;

import org.apache.poi.xwpf.usermodel.*;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;

import java.math.BigInteger;

public class CreateWordHeaderFooterSpacing {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument();

  // create header-footer
  XWPFHeaderFooterPolicy headerFooterPolicy = document.getHeaderFooterPolicy();
  if (headerFooterPolicy == null) headerFooterPolicy = document.createHeaderFooterPolicy();

  // create footer start
  XWPFFooter footer = headerFooterPolicy.createFooter(XWPFHeaderFooterPolicy.DEFAULT);

  XWPFParagraph paragraph = footer.getParagraphArray(0);
  paragraph.setAlignment(ParagraphAlignment.CENTER);

  XWPFRun run = paragraph.createRun();  
  run.setText("Footer");

  CTSectPr sectPr = document.getDocument().getBody().getSectPr();
  if (sectPr == null) sectPr = document.getDocument().getBody().addNewSectPr();
  CTPageMar pageMar = sectPr.getPgMar();
  if (pageMar == null) pageMar = sectPr.addNewPgMar();
  pageMar.setLeft(BigInteger.valueOf(720)); //720 TWentieths of an Inch Point (Twips) = 720/20 = 36 pt = 36/72 = 0.5"
  pageMar.setRight(BigInteger.valueOf(720));
  pageMar.setTop(BigInteger.valueOf(1440)); //1440 Twips = 1440/20 = 72 pt = 72/72 = 1"
  pageMar.setFooter(BigInteger.valueOf(720)); //0.5" footer margin
  long notPrintableBottomPageRange = (long)(0.038888*72*20); //0.038888" gap for non printable bottom page range
  pageMar.setBottom(BigInteger.valueOf(1152+720+notPrintableBottomPageRange)); //1152 Twips = 1152/20/72 = 0.8"
  //bottom margin = 0.8" footer spacing + 0.5" footer margin + 0.038888" gap for non printable bottom page range

  document.write(new FileOutputStream("CreateWordHeaderFooterSpacing.docx"));

  document.close();

 }
}