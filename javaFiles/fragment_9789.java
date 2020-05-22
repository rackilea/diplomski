import java.io.*;

import org.apache.poi.*;
import org.apache.poi.ooxml.*;
import org.apache.poi.openxml4j.opc.*;

import org.apache.poi.xwpf.usermodel.*;

import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAltChunk;

public class WordInsertHTMLaltChunkInDocument {

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

 //a method for replacing a IBodyElement containing a special text with CTAltChunk which
 //references MyXWPFHtmlDocument
 private static void replaceIBodyElementWithAltChunk(XWPFDocument document, String textToFind, 
                                                     MyXWPFHtmlDocument myXWPFHtmlDocument) throws Exception {
  int pos = 0;
  for (IBodyElement bodyElement : document.getBodyElements()) {
   if (bodyElement instanceof XWPFParagraph) {
    XWPFParagraph paragraph = (XWPFParagraph)bodyElement;
    String text = paragraph.getText();
    if (text != null && text.contains(textToFind)) {
     //create XmlCursor at this paragraph
     XmlCursor cursor = paragraph.getCTP().newCursor();
     cursor.toEndToken(); //now we are at end of the paragraph
     //there always must be a next start token. Either a p or at least sectPr.
     while(cursor.toNextToken() != org.apache.xmlbeans.XmlCursor.TokenType.START);
     //now we can insert the CTAltChunk here
     String uri = CTAltChunk.type.getName().getNamespaceURI();
     cursor.beginElement("altChunk", uri);
     cursor.toParent();
     CTAltChunk cTAltChunk = (CTAltChunk)cursor.getObject();
     //set the altChunk's Id to reference the given MyXWPFHtmlDocument
     cTAltChunk.setId(myXWPFHtmlDocument.getId());

     //now remove the found IBodyElement
     document.removeBodyElement(pos);

     break; //break for each loop
    }
   }
   pos++;
  }
 }

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument(new FileInputStream("template.docx"));

  MyXWPFHtmlDocument myXWPFHtmlDocument = createHtmlDoc(document, "htmlDoc1");
  myXWPFHtmlDocument.setHtml(myXWPFHtmlDocument.getHtml().replace("<body></body>",
   "<body><p>Simple <b>HTML</b> <i>formatted</i> <u>text</u></p></body>"));

  replaceIBodyElementWithAltChunk(document, "${content}", myXWPFHtmlDocument);

  FileOutputStream out = new FileOutputStream("result.docx");
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