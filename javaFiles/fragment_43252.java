package com.concretepage;
import java.io.FileInputStream;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
public class ReadDOCXHeaderFooter {
   public static void main(String[] args) {
     try {
     FileInputStream fis = new FileInputStream("D:/docx/read-test.docx");
     XWPFDocument xdoc=new XWPFDocument(OPCPackage.open(fis));
     XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(xdoc);
     //read header
     XWPFHeader header = policy.getDefaultHeader();
     System.out.println(header.getText());
     //read footer
     XWPFFooter footer = policy.getDefaultFooter();
     System.out.println(footer.getText());
     } catch(Exception ex) {
    ex.printStackTrace();
     } 
  }
}