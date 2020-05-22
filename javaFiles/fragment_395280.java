import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.ClientAnchor.AnchorType;
import org.apache.poi.util.IOUtils;

import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPictureNonVisual;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHyperlink;

import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;

public class CreateExcelPicturesHyperlink {

 private static Picture drawImageOnExcelSheet(Sheet sheet, int row1, int col1, 
  int row2, int col2, String pictureurl, int picturetype) throws Exception {

  InputStream is = new FileInputStream(pictureurl);
  byte[] bytes = IOUtils.toByteArray(is);
  int pictureIdx = sheet.getWorkbook().addPicture(bytes, picturetype);
  is.close();

  CreationHelper helper = sheet.getWorkbook().getCreationHelper();

  Drawing drawing = sheet.createDrawingPatriarch();

  ClientAnchor anchor = helper.createClientAnchor();
  anchor.setAnchorType(AnchorType.MOVE_AND_RESIZE);

  anchor.setRow1(row1); //first anchor determines upper left position
  anchor.setCol1(col1); 
  anchor.setRow2(row2); //second anchor determines bottom right position
  anchor.setCol2(col2);

  Picture picture = drawing.createPicture(anchor, pictureIdx);
  return picture;
 }

 private static void setHyperlinkToPicture(Picture picture, String hyperlinkurl) throws Exception {
  if (picture instanceof XSSFPicture) {
   XSSFPicture xssfpicture = (XSSFPicture)picture;

   XSSFDrawing drawing = xssfpicture.getSheet().createDrawingPatriarch();
   PackageRelationship packagerelationship = 
    drawing.getPackagePart().addExternalRelationship(hyperlinkurl, PackageRelationshipTypes.HYPERLINK_PART);
   String rid = packagerelationship.getId();

   CTPicture ctpicture = xssfpicture.getCTPicture();
   CTPictureNonVisual ctpicturenonvisual = ctpicture.getNvPicPr();
   if (ctpicturenonvisual == null) ctpicturenonvisual = ctpicture.addNewNvPicPr();
   CTNonVisualDrawingProps ctnonvisualdrawingprops = ctpicturenonvisual.getCNvPr();
   if (ctnonvisualdrawingprops == null) ctnonvisualdrawingprops = ctpicturenonvisual.addNewCNvPr();
   CTHyperlink cthyperlink = ctnonvisualdrawingprops.getHlinkClick();
   if (cthyperlink == null) cthyperlink = ctnonvisualdrawingprops.addNewHlinkClick();
   cthyperlink.setId(rid);

  }
 }

 public static void main(String[] args) throws Exception {

  Workbook workbook = new XSSFWorkbook();
  Sheet sheet = workbook.createSheet("Sheet1");

  Picture picture = drawImageOnExcelSheet(sheet, 2, 2, 4, 4, "samplePict1.jpeg", Workbook.PICTURE_TYPE_JPEG);
  setHyperlinkToPicture(picture, "http://www.google.de");

  workbook.createSheet("Sheet2");
  picture = drawImageOnExcelSheet(sheet, 6, 2, 8, 4, "samplePict2.png", Workbook.PICTURE_TYPE_PNG);
  setHyperlinkToPicture(picture, "#Sheet2!B3");

  workbook.write(new FileOutputStream("CreateExcelPicturesHyperlink.xlsx"));
  workbook.close();

 }

}