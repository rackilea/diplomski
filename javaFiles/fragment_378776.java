import java.io.*;

import org.apache.poi.*;
import org.apache.poi.ooxml.*;
import org.apache.poi.openxml4j.opc.*;

import org.apache.poi.xwpf.usermodel.*;

public class CreateWordWithHTMLaltChunk {

 //a method for creating the htmlDoc /word/htmlDoc#.html in the *.docx ZIP archive  
 //String id will be htmlDoc#.
 private static MyXWPFHtmlDocument createHtmlDoc(XWPFDocument document, String id) throws Exception {
  OPCPackage oPCPackage = document.getPackage();
  PackagePartName partName = PackagingURIHelper.createPartName("/word/" + id + ".html");
  PackagePart part = oPCPackage.createPart(partName, "text/html");
  MyXWPFHtmlDocument myXWPFHtmlDocument = new MyXWPFHtmlDocument(part, id);
  document.addRelation(myXWPFHtmlDocument.getId(), new XWPFHtmlRelation(), myXWPFHtmlDocument);
  return myXWPFHtmlDocument;
 }

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument();

  XWPFParagraph paragraph;
  XWPFRun run;
  MyXWPFHtmlDocument myXWPFHtmlDocument;

  paragraph = document.createParagraph();
  run = paragraph.createRun();
  run.setText("Default paragraph followed by first HTML chunk.");

  myXWPFHtmlDocument = createHtmlDoc(document, "htmlDoc1");
  myXWPFHtmlDocument.setHtml(myXWPFHtmlDocument.getHtml().replace("<body></body>",
   "<body><p>Simple <b>HTML</b> <i>formatted</i> <u>text</u></p></body>"));
  document.getDocument().getBody().addNewAltChunk().setId(myXWPFHtmlDocument.getId());  

  paragraph = document.createParagraph();
  run = paragraph.createRun();
  run.setText("Default paragraph followed by second HTML chunk.");

  myXWPFHtmlDocument = createHtmlDoc(document, "htmlDoc2");
  myXWPFHtmlDocument.setHtml(myXWPFHtmlDocument.getHtml().replace("<body></body>",
   "<body>" +
   "<table>"+
   "<caption>A table></caption>" +
   "<tr><th>Name</th><th>Date</th><th>Amount</th></tr>" +
   "<tr><td>John Doe</td><td>2018-12-01</td><td>1,234.56</td></tr>" +
   "</table>" +
   "</body>"
   ));
  document.getDocument().getBody().addNewAltChunk().setId(myXWPFHtmlDocument.getId());  

  FileOutputStream out = new FileOutputStream("CreateWordWithHTMLaltChunk.docx");
  document.write(out);
  out.close();
  document.close();

 }

 //a wrapper class for the  htmlDoc /word/htmlDoc#.html in the *.docx ZIP archive
 //provides methods for manipulating the HTML
 //TODO: We should *not* using String methods for manipulating HTML!
 private static class MyXWPFHtmlDocument extends POIXMLDocumentPart {

  private String html;
  private String id;

  private MyXWPFHtmlDocument(PackagePart part, String id) throws Exception {
   super(part);
   this.html = "<!DOCTYPE html><html><head><style></style><title>HTML import</title></head><body></body>";
   this.id = id;
  }

  private String getId() {
   return id;
  }

  private String getHtml() {
   return html;
  }

  private void setHtml(String html) {
   this.html = html;
  }

  @Override
  protected void commit() throws IOException {
   PackagePart part = getPackagePart();
   OutputStream out = part.getOutputStream();
   Writer writer = new OutputStreamWriter(out, "UTF-8");
   writer.write(html);
   writer.close();
   out.close();
  }

 }

 //the XWPFRelation for /word/htmlDoc#.html
 private final static class XWPFHtmlRelation extends POIXMLRelation {
  private XWPFHtmlRelation() {
   super(
    "text/html", 
    "http://schemas.openxmlformats.org/officeDocument/2006/relationships/aFChunk", 
    "/word/htmlDoc#.html");
  }
 }
}