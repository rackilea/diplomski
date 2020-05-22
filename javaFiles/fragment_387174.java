import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.wp.usermodel.HeaderFooterType;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHdrFtr;

public class CreateWordMultipleSectionPageNumbering {

 //default section setting for page size and page borders
 //measurement unit = twips (twentieth of an inch point) = 1 inch = 1440 twips
 private static String defaultSectPr = 
   "<w:sectPr xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\">"
  +"<w:pgSz w:w=\"12240\" w:h=\"15840\"/>" //A4
  +"<w:pgMar w:top=\"1417\" w:right=\"1417\" w:bottom=\"1134\" w:left=\"1417\""
  +" w:header=\"720\" w:footer=\"720\" w:gutter=\"0\"/>"
  +"<w:cols w:space=\"720\"/>"
  +"</w:sectPr>"; 

 public static void main(String[] args) throws Exception {

  CTSectPr ctSectPrDefault = (CTPPr.Factory.parse(defaultSectPr)).getSectPr();

  XWPFDocument document= new XWPFDocument();

  //set the default section setting for page size and page borders 
  CTDocument1 ctDocument = document.getDocument();
  CTBody ctBody = ctDocument.getBody();
  ctBody.setSectPr(ctSectPrDefault);

  //create first footer for section 2 - first created as first footer for the document
  XWPFFooter footer = document.createFooter(HeaderFooterType.FIRST); 
  //making it HeaderFooterType.FIRST first to be able creating one more footer later
  //will changing this later to HeaderFooterType.DEFAULT

  XWPFParagraph paragraph = footer.getParagraphArray(0);
  if (paragraph == null) paragraph = footer.createParagraph();
  paragraph.setAlignment(ParagraphAlignment.CENTER);

  XWPFRun run = paragraph.createRun();  
  run.setText("Page ");
  paragraph.getCTP().addNewFldSimple().setInstr("PAGE \\* ROMAN MERGEFORMAT");
  run = paragraph.createRun();  
  run.setText(" of ");
  //paragraph.getCTP().addNewFldSimple().setInstr("NUMPAGES \\* ROMAN MERGEFORMAT");
  paragraph.getCTP().addNewFldSimple().setInstr("SECTIONPAGES \\* ROMAN MERGEFORMAT");

  //create second footer for section 3 == last section in document
  footer = document.createFooter(HeaderFooterType.DEFAULT);

  paragraph = footer.getParagraphArray(0);
  if (paragraph == null) paragraph = footer.createParagraph();
  paragraph.setAlignment(ParagraphAlignment.CENTER);

  run = paragraph.createRun();  
  run.setText("Page ");
  paragraph.getCTP().addNewFldSimple().setInstr("PAGE \\* ARABIC MERGEFORMAT");
  run = paragraph.createRun();  
  run.setText(" of ");
  //paragraph.getCTP().addNewFldSimple().setInstr("NUMPAGES \\* ARABIC MERGEFORMAT");
  paragraph.getCTP().addNewFldSimple().setInstr("SECTIONPAGES \\* ARABIC MERGEFORMAT");

  //create document content.

  //section 1
  paragraph = document.createParagraph();
  run=paragraph.createRun();  
  run.setText("Cover");

  //paragraph with section setting for section above
  paragraph = document.createParagraph();
  paragraph.getCTP().addNewPPr().setSectPr(ctSectPrDefault);

  //section 2
  paragraph = document.createParagraph();
  run=paragraph.createRun();  
  run.setText("Contents");
  paragraph = document.createParagraph();
  run = paragraph.createRun();
  run.setText("Lorem ipsum semit dolor ...");
  run.addBreak(BreakType.PAGE); 
  paragraph = document.createParagraph();

  //paragraph with section setting for section above
  paragraph = document.createParagraph();
  paragraph.getCTP().addNewPPr().setSectPr(ctSectPrDefault);  
  CTSectPr ctSectPrSect2 = paragraph.getCTP().getPPr().getSectPr(); //we need this later
  //set this page numbering starting with 1 again
  ctSectPrSect2.addNewPgNumType().setStart(java.math.BigInteger.valueOf(1));

  //section 3 
  paragraph = document.createParagraph();
  run=paragraph.createRun();
  run.setText("Text");
  paragraph = document.createParagraph();
  run = paragraph.createRun();
  run.setText("Lorem ipsum semit dolor ...");
  run.addBreak(BreakType.PAGE); 
  paragraph = document.createParagraph();

  //section setting for section above == last section in document
  CTSectPr ctSectPrLastSect = ctBody.getSectPr(); 
  //there must be a SectPr already because of the default and footer settings above
  //set this page numbering starting with 1 again
  ctSectPrLastSect.addNewPgNumType().setStart(java.math.BigInteger.valueOf(1));

  //get footer reference of first footer and move this to be footer reference for section 2
  CTHdrFtrRef ctHdrFtrRef = ctSectPrLastSect.getFooterReferenceArray(0);
  ctHdrFtrRef.setType(STHdrFtr.DEFAULT); //change this from STHdrFtr.FIRST to STHdrFtr.DEFAULT
  CTHdrFtrRef[] ctHdrFtrRefs = new CTHdrFtrRef[]{ctHdrFtrRef};
  ctSectPrSect2.setFooterReferenceArray(ctHdrFtrRefs);
  ctSectPrLastSect.removeFooterReference(0);

  //unset "there is a title page" for the whole document because we have a section for the title (cover)
  ctSectPrLastSect.unsetTitlePg();

  document.write(new FileOutputStream("CreateWordMultipleSectionPageNumbering.docx"));

 }
}