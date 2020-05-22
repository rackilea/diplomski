import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.ClientAnchor.AnchorType;
import org.apache.poi.util.IOUtils;

import org.apache.poi.util.Units;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;

public class CreateExcelWithPictures {

 private static Picture drawImageOnExcelSheet(Sheet sheet, 
  int col1, int row1, int dx1/*1/256th of a character width*/, int dy1/*points*/,
  int col2, int row2, int dx2/*1/256th of a character width*/, int dy2/*points*/, 
  String pictureurl, int picturetype, boolean resize) throws Exception {

  int DEFAULT_COL_WIDTH = 10 * 256;
  float DEFAULT_ROW_HEIGHT = 12.75f;

  Row row = sheet.getRow(row1);
  float rowheight1 = (row!=null)?row.getHeightInPoints():DEFAULT_ROW_HEIGHT;
  row = sheet.getRow(row2);
  float rowheight2 = (row!=null)?row.getHeightInPoints():DEFAULT_ROW_HEIGHT;

  int colwidth1 = sheet.getColumnWidth(col1);
  int colwidth2 = sheet.getColumnWidth(col2);

  InputStream is = new FileInputStream(pictureurl);
  byte[] bytes = IOUtils.toByteArray(is);
  int pictureIdx = sheet.getWorkbook().addPicture(bytes, picturetype);
  is.close();

  CreationHelper helper = sheet.getWorkbook().getCreationHelper();

  Drawing drawing = sheet.createDrawingPatriarch();

  ClientAnchor anchor = helper.createClientAnchor();
  anchor.setAnchorType(AnchorType.DONT_MOVE_AND_RESIZE);

  anchor.setRow1(row1); //first anchor determines upper left position
  if (sheet instanceof XSSFSheet) {
   anchor.setDy1(dy1 * Units.EMU_PER_POINT);
  } else if (sheet instanceof HSSFSheet) {
   anchor.setDy1((int)Math.round(dy1 * Units.PIXEL_DPI / Units.POINT_DPI * 14.75 * DEFAULT_ROW_HEIGHT / rowheight1));
  }
  anchor.setCol1(col1); 
  if (sheet instanceof XSSFSheet) {
   anchor.setDx1((int)Math.round(dx1 * Units.EMU_PER_PIXEL * Units.DEFAULT_CHARACTER_WIDTH / 256f));
  } else if (sheet instanceof HSSFSheet) {
   anchor.setDx1((int)Math.round(dx1 * Units.DEFAULT_CHARACTER_WIDTH / 256f * 14.75 * DEFAULT_COL_WIDTH / colwidth1));
  }

  if (!resize) {
   anchor.setRow2(row2); //second anchor determines bottom right position
   if (sheet instanceof XSSFSheet) {
    anchor.setDy2(dy2 * Units.EMU_PER_POINT);
   } else if (sheet instanceof HSSFSheet) {
    anchor.setDy2((int)Math.round(dy2 * Units.PIXEL_DPI / Units.POINT_DPI * 14.75 * DEFAULT_ROW_HEIGHT / rowheight2));
   }
   anchor.setCol2(col2);
   if (sheet instanceof XSSFSheet) {
    anchor.setDx2((int)Math.round(dx2 * Units.EMU_PER_PIXEL * Units.DEFAULT_CHARACTER_WIDTH / 256f));
   } else if (sheet instanceof HSSFSheet) {
    anchor.setDx2((int)Math.round(dx2 * Units.DEFAULT_CHARACTER_WIDTH / 256f * 14.75 * DEFAULT_COL_WIDTH / colwidth2));
   }
  }

  Picture picture = drawing.createPicture(anchor, pictureIdx);

  if (resize) picture.resize();

  return picture;
 }

 public static void main(String[] args) throws Exception {

  Workbook workbook = new XSSFWorkbook();
  //Workbook workbook = new HSSFWorkbook();

  Sheet sheet = workbook.createSheet("Sheet1");
  sheet.setColumnWidth(1, 6000/*1/256th of a character width*/);

  Row row = sheet.createRow(0);
  row.setHeightInPoints(100/*points*/);

  row = sheet.createRow(10);
  row.setHeightInPoints(50/*points*/);

  Picture picture;

  //two cell anchor in the same cell (B1) used without resizing the picture
  picture = drawImageOnExcelSheet(sheet, 
   1, 0, 1000/*1/256th of a character width*/, 10/*points*/, 
   1, 0, 5000/*1/256th of a character width*/, 90/*points*/, 
   "mikt1.png", Workbook.PICTURE_TYPE_PNG, false);

  //one cell anchor (B3) used with resizing the picture
  picture = drawImageOnExcelSheet(sheet, 
   1, 2, 1000/*1/256th of a character width*/, 10/*points*/, 
   0, 0, 0, 0, 
   "mikt1.png", Workbook.PICTURE_TYPE_PNG, true);

  //two cell anchor (B10 to B12) used without resizing the picture
  picture = drawImageOnExcelSheet(sheet, 
   1, 9, 1000/*1/256th of a character width*/, 10/*points*/, 
   1, 11, 5000/*1/256th of a character width*/, 10/*points*/, 
   "mikt1.png", Workbook.PICTURE_TYPE_PNG, false);

  if (workbook instanceof XSSFWorkbook) {
   workbook.write(new FileOutputStream("image-sutpid.xlsx"));
  } else if (workbook instanceof HSSFWorkbook) {
   workbook.write(new FileOutputStream("image-sutpid.xls"));
  }
  workbook.close();

 }

}