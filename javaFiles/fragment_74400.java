import java.io.*;
import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;

import java.util.List;
import java.util.ArrayList;

import java.math.BigInteger;

public class WordGetAllSectPr {

 public static List<CTSectPr> getAllSectPr(XWPFDocument document) {
  List<CTSectPr> allSectPr = new ArrayList<>();
  for (XWPFParagraph paragraph : document.getParagraphs()) {
   if (paragraph.getCTP().getPPr() != null && paragraph.getCTP().getPPr().getSectPr() != null) {
    allSectPr.add(paragraph.getCTP().getPPr().getSectPr());
   }
  }
  allSectPr.add(document.getDocument().getBody().getSectPr());
  return allSectPr;
 }

 public static void main(String[] args) throws Exception {

  XWPFDocument docx = new XWPFDocument(new FileInputStream("template.docx"));

  List<CTSectPr> allSectPr = getAllSectPr(docx);
System.out.println(allSectPr.size());

  for (CTSectPr sectPr : allSectPr) {
   CTPageMar pageMar = sectPr.getPgMar();
   pageMar.setLeft(BigInteger.valueOf(1200L));
   pageMar.setTop(BigInteger.valueOf(500L));
   pageMar.setRight(BigInteger.valueOf(800L));
   pageMar.setBottom(BigInteger.valueOf(1440L));
  }

  docx.write(new FileOutputStream("test2.docx"));
  docx.close();
 }

}