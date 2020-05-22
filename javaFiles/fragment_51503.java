import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.streaming.*;

import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;

import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.model.ThemesTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorderPr;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.STBorderStyle;

import java.io.FileOutputStream;
import java.io.IOException;


class CellDiagonalBorders {

 private static CTBorder getCTBorder(StylesTable _stylesSource, CTXf _cellXf ) {
  CTBorder ct;
  if(_cellXf.getApplyBorder()) {
   int idx = (int)_cellXf.getBorderId();
   XSSFCellBorder cf = _stylesSource.getBorderAt(idx);
   ct = (CTBorder)cf.getCTBorder().copy();
   } else {
    ct = CTBorder.Factory.newInstance();
   }
  return ct;
 }

 public static void setBorderDiagonal(BorderStyle border, StylesTable _stylesSource, CTXf _cellXf, ThemesTable _theme) {
  CTBorder ct = getCTBorder(_stylesSource, _cellXf);
  CTBorderPr pr = ct.isSetDiagonal() ? ct.getDiagonal() : ct.addNewDiagonal();
  if(border == BorderStyle.NONE) {
   ct.unsetDiagonal();
  }
  else {
   ct.setDiagonalDown(true);
   ct.setDiagonalUp(true);
   pr.setStyle(STBorderStyle.Enum.forInt(border.getCode() + 1));
  }
  int idx = _stylesSource.putBorder(new XSSFCellBorder(ct, _theme, _stylesSource.getIndexedColors()));    
  _cellXf.setBorderId(idx);
  _cellXf.setApplyBorder(true);   
 }

 public static void main(String[] args) throws Exception {
  //Workbook wb = new XSSFWorkbook();
  Workbook wb = new SXSSFWorkbook(SXSSFWorkbook.DEFAULT_WINDOW_SIZE);

  CellStyle style = wb.createCellStyle();
  style.setBorderTop(BorderStyle.THICK);
  style.setBorderBottom(BorderStyle.THICK);

  StylesTable _stylesSource = null;
  if (wb instanceof SXSSFWorkbook) {
   _stylesSource = ((SXSSFWorkbook)wb).getXSSFWorkbook().getStylesSource();
  } else if (wb instanceof XSSFWorkbook) {
   _stylesSource = ((XSSFWorkbook)wb).getStylesSource();
  }
  if (_stylesSource != null) {
   ThemesTable _theme = _stylesSource.getTheme();
   CTXf _cellXf = ((XSSFCellStyle)style).getCoreXf();
   setBorderDiagonal(BorderStyle.DOUBLE, _stylesSource, _cellXf, _theme);
  }

  style.setBorderLeft(BorderStyle.THICK);
  style.setBorderRight(BorderStyle.THICK);

  Sheet sheet = wb.createSheet("Sheet1");

  for (int r = 1; r < 1000; r++) {
   Cell cell = sheet.createRow(r).createCell(2);
   cell.setCellStyle(style);
  }

  FileOutputStream fileOut = new FileOutputStream("CellDiagonalBorders.xlsx");
  wb.write(fileOut);
  wb.close();
  if (wb instanceof SXSSFWorkbook) ((SXSSFWorkbook)wb).dispose();

 }
}