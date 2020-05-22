import java.io.*;

import org.apache.poi.*;
import org.apache.poi.openxml4j.opc.*;
import org.apache.xmlbeans.*;

import org.apache.poi.xwpf.usermodel.*;

import static org.apache.poi.POIXMLTypeLoader.DEFAULT_XML_OPTIONS;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import javax.xml.namespace.QName;

import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.Locale;

public class WordChangeComments {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument(new FileInputStream("WordDocumentHavingComments.docx"));

  for (POIXMLDocumentPart.RelationPart rpart : document.getRelationParts()) {
   String relation = rpart.getRelationship().getRelationshipType();
   if (relation.equals(XWPFRelation.COMMENT.getRelation())) {
    POIXMLDocumentPart part = rpart.getDocumentPart(); //this is only POIXMLDocumentPart, not a high level class extending POIXMLDocumentPart
    //provide class extending POIXMLDocumentPart for comments 
    MyXWPFCommentsDocument myXWPFCommentsDocument = new MyXWPFCommentsDocument(part.getPackagePart());
    //and registering this relation instead of only relation to POIXMLDocumentPart
    String rId = document.getRelationId(part);
    document.addRelation(rId, XWPFRelation.COMMENT, myXWPFCommentsDocument);

    //now the comments are available from the new MyXWPFCommentsDocument 
    for (CTComment ctComment : myXWPFCommentsDocument.getComments().getCommentArray()) {

     System.out.print("Comment: Id: " + ctComment.getId());
     System.out.print(", Author: " + ctComment.getAuthor());
     System.out.print(", Date: " + ctComment.getDate());
     System.out.print(", Text: ");
     for (CTP ctp : ctComment.getPArray()) {
      System.out.print(ctp.newCursor().getTextValue());
     }
     System.out.println();

     //and changings can be made which were committed while writing the XWPFDocument
     if (BigInteger.ONE.equals(ctComment.getId())) { //the second comment (Id 0 = first)
      ctComment.setAuthor("New Author");
      ctComment.setInitials("NA");
      ctComment.setDate(new GregorianCalendar(Locale.US));
      CTP newCTP = CTP.Factory.newInstance();
      newCTP.addNewR().addNewT().setStringValue("The new Text for Comment with Id 1.");
      ctComment.setPArray(new CTP[]{newCTP });
     }
    }
   }
  }

  document.write(new FileOutputStream("WordDocumentHavingComments.docx"));

  document.close();
 }

//a wrapper class for the CommentsDocument /word/comments.xml in the *.docx ZIP archive
 private static class MyXWPFCommentsDocument extends POIXMLDocumentPart {

  private CTComments comments;

  private MyXWPFCommentsDocument(PackagePart part) throws Exception {
   super(part);
   comments = CommentsDocument.Factory.parse(part.getInputStream(), DEFAULT_XML_OPTIONS).getComments();
  }

  private CTComments getComments() {
   return comments;
  }

  @Override
  protected void commit() throws IOException {

System.out.println("============MyXWPFCommentsDocument is committed=================");

   XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
   xmlOptions.setSaveSyntheticDocumentElement(new QName(CTComments.type.getName().getNamespaceURI(), "comments"));
   PackagePart part = getPackagePart();
   OutputStream out = part.getOutputStream();
   comments.save(out, xmlOptions);
   out.close();
  }

 }

}