import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xddf.usermodel.*;
import org.apache.poi.xddf.usermodel.chart.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;

import java.util.GregorianCalendar;

class CreateExcelLIneChartDataAxis {

 private static void addLineChart(XSSFSheet sheet, CellRangeAddress anchorRange, 
  CellRangeAddress[] titleRanges, CellRangeAddress[] dataRanges, PresetColor[] lineColors) {

  XSSFDrawing drawing = sheet.createDrawingPatriarch();
  XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 
   anchorRange.getFirstColumn(), 
   anchorRange.getFirstRow(),
   anchorRange.getLastColumn(),
   anchorRange.getLastRow()
  );
  XSSFChart chart = drawing.createChart(anchor);
  XDDFChartLegend legend = chart.getOrAddLegend();
  legend.setPosition(LegendPosition.BOTTOM);

  XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
  // if a date axis is needed instead of a category axis, comment the above and uncomment the next
  //XDDFDateAxis bottomAxis = chart.createDateAxis(AxisPosition.BOTTOM);

  XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
  leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
  leftAxis.setCrossBetween(AxisCrossBetween.BETWEEN);
  XDDFChartData data = chart.createData(ChartTypes.LINE, bottomAxis, leftAxis);
  data.setVaryColors(false);
  //XDDFDataSource<String> cat = XDDFDataSourcesFactory.fromStringCellRange(sheet, dataRanges[0]);
  // we have dates (numeric data) as category values
  XDDFDataSource<Double> cat = XDDFDataSourcesFactory.fromNumericCellRange(sheet, dataRanges[0]);
  for (int s = 1; s < dataRanges.length; s++) {
   XDDFNumericalDataSource<Double> ser = XDDFDataSourcesFactory.fromNumericCellRange(sheet, dataRanges[s]);
   XDDFChartData.Series series = data.addSeries(cat, ser);
   series.setTitle(
    sheet.getRow(titleRanges[s].getFirstRow()).getCell(titleRanges[s].getFirstColumn()).getStringCellValue(), 
    new CellReference(sheet.getSheetName(), titleRanges[s].getFirstRow(), titleRanges[s].getFirstColumn(), true, true)
   );
   if (series instanceof XDDFLineChartData.Series) {
    ((XDDFLineChartData.Series)series).setSmooth(false);
   }
  }
  chart.plot(data);

  // some corrections
  // set line colors (necessary for LibreOffice or OpenOffice Calc to show the lines)
  for (int s = 0; s < data.getSeries().size(); s++) {
   solidLineSeries(data, s, lineColors[s]);
  }

  // some proper default options for Excel versions later than 2007
  if (chart.getCTChart().getPlotArea().getCatAxList().size() > 0) {
   chart.getCTChart().getPlotArea().getCatAxArray(0).addNewAuto().setVal(false); // no auto axis type
   chart.getCTChart().getPlotArea().getCatAxArray(0).addNewNumFmt().setSourceLinked(true); // number format linked to source
   chart.getCTChart().getPlotArea().getCatAxArray(0).getNumFmt().setFormatCode(""); // dummy
  } else if (chart.getCTChart().getPlotArea().getDateAxList().size() > 0) {
   chart.getCTChart().getPlotArea().getDateAxArray(0).addNewAuto().setVal(false);
   chart.getCTChart().getPlotArea().getDateAxArray(0).addNewNumFmt().setSourceLinked(true);
   chart.getCTChart().getPlotArea().getDateAxArray(0).getNumFmt().setFormatCode("");
  }
 }

 private static void solidLineSeries(XDDFChartData data, int index, PresetColor color) {
  XDDFSolidFillProperties fill = new XDDFSolidFillProperties(XDDFColor.from(color));
  XDDFLineProperties line = new XDDFLineProperties();
  line.setFillProperties(fill);
  XDDFChartData.Series series = data.getSeries().get(index);
  XDDFShapeProperties properties = series.getShapeProperties();
  if (properties == null) {
   properties = new XDDFShapeProperties();
  }
  properties.setLineProperties(line);
  series.setShapeProperties(properties);
 }

 public static void main(String[] args) throws Exception {

  Object[][] data = new Object[][] {
   new Object[] {"Date", "Value"},
   new Object[] {new GregorianCalendar(2019,0,1), 100d},
   new Object[] {new GregorianCalendar(2019,0,2), 99d},
   new Object[] {new GregorianCalendar(2019,0,3), 98d},
   new Object[] {new GregorianCalendar(2019,2,15), 99.5},
   new Object[] {new GregorianCalendar(2019,3,15), 100d}
  };

  try (XSSFWorkbook workbook = new XSSFWorkbook();
       FileOutputStream fileout = new FileOutputStream("Excel.xlsx") ) {

   DataFormat format = workbook.createDataFormat();
   XSSFCellStyle dateStyle = workbook.createCellStyle();
   dateStyle.setDataFormat(format.getFormat("yyyy-MM-dd"));

   XSSFSheet sheet = workbook.createSheet();
   XSSFRow row;
   int rowNum = 0;
   for (Object[] rowData : data) {
    row = sheet.createRow(rowNum++);
    for (int c = 0; c < rowData.length; c++) {
     if (rowData[c] instanceof String) {
      row.createCell(c).setCellValue((String)rowData[c]);
     } else if (rowData[c] instanceof GregorianCalendar) {
      row.createCell(c).setCellValue((GregorianCalendar)rowData[c]);
      row.getCell(c).setCellStyle(dateStyle);
     } else if (rowData[c] instanceof Double) {
      row.createCell(c).setCellValue((Double)rowData[c]);
     }
    }
   }

   sheet.setColumnWidth(0, 12*256);

   addLineChart(sheet, new CellRangeAddress(0, 15, 3, 14), // chart in range D1:O16
    new CellRangeAddress[]{
     new CellRangeAddress(0, 0, 0, 0), // title for x (cat)
     new CellRangeAddress(0, 0, 1, 1) // title for series 1
    },
    new CellRangeAddress[]{
     new CellRangeAddress(1, data.length-1, 0, 0), // data x (cat)
     new CellRangeAddress(1, data.length-1, 1, 1) // data series 1
    },
    new PresetColor[] {PresetColor.BLUE}
   );

   workbook.write(fileout);
  }

 }
}