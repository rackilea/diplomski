import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.wp.usermodel.HeaderFooterType;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHdrFtr;

public class CreateWordMultipleSectionPageNumbering {

 public static void main(String[] args) throws Exception {

  XWPFDocument document= new XWPFDocument();

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
  paragraph.getCTP().addNewFldSimple().setInstr("NUMPAGES \\* ROMAN MERGEFORMAT");

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
  paragraph.getCTP().addNewFldSimple().setInstr("NUMPAGES \\* ARABIC MERGEFORMAT");

  //create document content.

  //section 1
  paragraph = document.createParagraph();
  run=paragraph.createRun();  
  run.setText("Cover");

  //paragraph with section setting for section above
  paragraph = document.createParagraph();
  CTSectPr ctSectPr = paragraph.getCTP().addNewPPr().addNewSectPr();

  //section 2
  paragraph = document.createParagraph();
  run=paragraph.createRun();  
  run.setText("Contents");

  //paragraph with section setting for section above
  paragraph = document.createParagraph();
  CTSectPr ctSectPrSect2 = paragraph.getCTP().addNewPPr().addNewSectPr(); //we need this later

  //section 3 
  paragraph = document.createParagraph();
  run=paragraph.createRun();
  run.setText("Text");

  //section setting for section above == last section in document
  CTDocument1 ctDocument = document.getDocument();
  CTBody ctBody = ctDocument.getBody();
  CTSectPr ctSectPrLastSect = ctBody.getSectPr(); //there must be a SectPr already because of the footer settings above

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