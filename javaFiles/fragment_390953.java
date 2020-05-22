import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTGradientFill;

public class CreateExcelCellGradientFillColor {

 public static void main(String[] args) throws Exception {
  XSSFWorkbook workbook = new XSSFWorkbook();

  Sheet sheet = workbook.createSheet();
  Row row = sheet.createRow(0);

  XSSFCellStyle cellstyle = workbook.createCellStyle();
  //set pattern fill settings only to have some fill to get the fill index from it
  cellstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

  //get fill index used in this CellStyle
  int fillidx = (int)cellstyle.getCoreXf().getFillId();

  //get the low level CTFill used in this CellStyle
  CTFill ctfill = workbook.getStylesSource().getFillAt(fillidx).getCTFill();
System.out.println(ctfill);

  //unset the pattern fill
  ctfill.unsetPatternFill();

  //now low level set the gradient fill
  byte[] rgb1 = new byte[3];
  rgb1[0] = (byte) 0; // red
  rgb1[1] = (byte) 0; // green
  rgb1[2] = (byte) 255; // blue

  byte[] rgb2 = new byte[3];
  rgb2[0] = (byte) 255; // red
  rgb2[1] = (byte) 255; // green
  rgb2[2] = (byte) 255; // blue

  CTGradientFill ctgradientfill = ctfill.addNewGradientFill();
  ctgradientfill.setDegree(90.0);
  ctgradientfill.addNewStop().setPosition(0.0);
  ctgradientfill.getStopArray(0).addNewColor().setRgb(rgb1);
  ctgradientfill.addNewStop().setPosition(0.5);
  ctgradientfill.getStopArray(1).addNewColor().setRgb(rgb2);
  ctgradientfill.addNewStop().setPosition(1.0);
  ctgradientfill.getStopArray(2).addNewColor().setRgb(rgb1);
System.out.println(ctfill);

  Cell cell = row.createCell(0);
  cell.setCellValue("");
  cell.setCellStyle(cellstyle);

  workbook.write(new FileOutputStream("CreateExcelCellGradientFillColor.xlsx"));
  workbook.close();
 }
}