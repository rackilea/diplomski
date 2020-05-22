import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;

import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;

import java.util.List;

class InsertRowsAboveChart {

 //a method for shift rows and shift all anchors in drawing below the shifted rows
 private static void insertRowsShiftShapes(Sheet sheet, int startRow, int n) {
  java.util.List<CTTwoCellAnchor> drawingAnchors = ((XSSFDrawing)sheet.getDrawingPatriarch()).getCTDrawing().getTwoCellAnchorList();
  for (CTTwoCellAnchor drawingAnchor : drawingAnchors) {
   int fromRow = drawingAnchor.getFrom().getRow();
   int toRow = drawingAnchor.getTo().getRow();
   if (fromRow >= startRow) {
    drawingAnchor.getFrom().setRow(fromRow + n);
    drawingAnchor.getTo().setRow(toRow + n);
   }
  }
  sheet.shiftRows(startRow, sheet.getLastRowNum(), n);
  correctDataRangesOfCharts(sheet, startRow, n);
 }

 //a method for correcting data ranges for charts which are affected of the shifted rows
 //!!working draft, not ready yet!!
 private static void correctDataRangesOfCharts(Sheet sheet, int startRow, int n) {
  java.util.List<XSSFChart> charts = ((XSSFDrawing)sheet.getDrawingPatriarch()).getCharts();
  for (XSSFChart chart : charts) {

   //pie charts
   java.util.List<CTPieChart> piecharts = chart.getCTChart().getPlotArea().getPieChartList();
   for (CTPieChart piechart : piecharts) {
    java.util.List<CTPieSer> pieseries = piechart.getSerList();
    for (CTPieSer pieserie : pieseries) {
     boolean strRefchanged = false;
     if (pieserie.getCat().isSetMultiLvlStrRef()) {
      String strRef = pieserie.getCat().getMultiLvlStrRef().getF();
      //todo: this only corrects the end row of the ranges, should also correct start row if affected
      int strRefEndRow = Integer.parseInt(strRef.substring(strRef.lastIndexOf('$') + 1));
      if (strRefEndRow >= startRow) {
       strRef = strRef.substring(0, strRef.lastIndexOf('$') +1) + (strRefEndRow + n);    
       pieserie.getCat().getMultiLvlStrRef().setF(strRef);
       strRefchanged = true;
      }
     } else if (pieserie.getCat().isSetStrRef()) {
      String strRef = pieserie.getCat().getStrRef().getF();
      int strRefEndRow = Integer.parseInt(strRef.substring(strRef.lastIndexOf('$') + 1));
      if (strRefEndRow >= startRow) {
       strRef = strRef.substring(0, strRef.lastIndexOf('$') +1) + (strRefEndRow + n);    
       pieserie.getCat().getStrRef().setF(strRef);
       strRefchanged = true;
      }
     }
     if (strRefchanged) {
      String numRef = pieserie.getVal().getNumRef().getF();
      int numRefEndRow = Integer.parseInt(numRef.substring(numRef.lastIndexOf('$') + 1));
      if (numRefEndRow >= startRow) {
       numRef = numRef.substring(0, numRef.lastIndexOf('$') +1) + (numRefEndRow + n);    
       pieserie.getVal().getNumRef().setF(numRef);
      }
     }
    }
   }
   //pie charts end

  }
 }

 public static void main(String[] args) {
  try {

   InputStream inp = new FileInputStream("Workbook.xlsx");
   Workbook wb = WorkbookFactory.create(inp);

   Sheet sheet = wb.getSheetAt(0);

   //sheet.shiftRows(3, 5, 4);
   insertRowsShiftShapes(sheet, 2, 4);

   FileOutputStream fileOut = new FileOutputStream("Workbook.xlsx");
   wb.write(fileOut);
   wb.close();

  } catch (InvalidFormatException ifex) {
  } catch (FileNotFoundException fnfex) {
  } catch (IOException ioex) {
  }
 }
}