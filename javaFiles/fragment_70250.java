import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRelation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;

import org.apache.xmlbeans.XmlObject;

public class WordGetWaterfallChart {

 static XWPFChartEx getFirstXWPFChartEx(XWPFDocument document) throws Exception {
  XWPFChartEx xwpfChartEx = null;
  for (POIXMLDocumentPart dpart : document.getRelations()) {
   PackagePart ppart = dpart.getPackagePart();
   if ("application/vnd.ms-office.chartex+xml".equals(ppart.getContentType())) {
    xwpfChartEx = new XWPFChartEx(dpart);
    String rId = document.getRelationId(dpart);
    document.addRelation(
     rId, 
     new XSSFChartExRelation(
      "application/vnd.ms-office.chartex+xml",
      "http://schemas.microsoft.com/office/2014/relationships/chartEx",
      "/word/charts/chartEx#.xml"),
      xwpfChartEx
    );
    return xwpfChartEx;
   }
  }
  return xwpfChartEx;
 }

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument(new FileInputStream("Waterfall_Chart.docx"));

  XWPFChartEx waterfallChart = getFirstXWPFChartEx(document);
  System.out.println(waterfallChart.getChartExXmlObject());
  //TODO: change the XML

  System.out.println(waterfallChart.getWorkbookPart());
  if (waterfallChart.getWorkbookPart() != null) {
   XSSFWorkbook workbook = new XSSFWorkbook(waterfallChart.getWorkbookPart().getInputStream());
   for (Sheet sheet : workbook) {
    for (Row row : sheet) {
     for (Cell cell : row) {
      System.out.println(cell);
      //TODO: change the cell contents
     }
    }
   }
   OutputStream wbOut = waterfallChart.getWorkbookPart().getOutputStream();
   workbook.write(wbOut);
   wbOut.close();
   workbook.close();
  }

  FileOutputStream out = new FileOutputStream("Waterfall_Chart_Changed.docx");
  document.write(out);
  out.close();
  document.close();
 }

 private static class XWPFChartEx extends POIXMLDocumentPart {

  private XmlObject chartExXmlObject;
  private PackagePart workbookPart;

  private XWPFChartEx(POIXMLDocumentPart dpart) throws Exception {
   super(dpart.getPackagePart());
   this.chartExXmlObject = XmlObject.Factory.parse(dpart.getPackagePart().getInputStream());
   for (POIXMLDocumentPart.RelationPart rpart : dpart.getRelationParts()) {
    if ("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
         .equals(rpart.getDocumentPart().getPackagePart().getContentType())) {
     this.addRelation(
      rpart.getRelationship().getId(), 
      XWPFRelation.getInstance(rpart.getRelationship().getRelationshipType()),
      rpart.getDocumentPart()
     );
     this.workbookPart = rpart.getDocumentPart().getPackagePart();
    }
   }
  }

  private XmlObject getChartExXmlObject() {
   return this.chartExXmlObject;
  }

  private PackagePart getWorkbookPart() {
   return this.workbookPart;
  }

  @Override
  protected void commit() throws IOException {
   PackagePart part = getPackagePart();
   OutputStream out = part.getOutputStream();
   chartExXmlObject.save(out);
   out.close();
  }
 }

 private static class XSSFChartExRelation extends POIXMLRelation {
  private XSSFChartExRelation(String type, String rel, String defaultName) {
   super(type, rel, defaultName);
  }
 }
}