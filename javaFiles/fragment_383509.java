import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xddf.usermodel.*;
import org.apache.poi.xddf.usermodel.chart.*;

public class XSSFLineChartTwoCatAxes {

 public static void main(String[] args) throws IOException {
  try (XSSFWorkbook wb = new XSSFWorkbook()) {
   XSSFSheet sheet = wb.createSheet("linechart");

   // create data
   Row row;
   Cell cell;
   for (int rowIndex = 0; rowIndex < 4; rowIndex++) {
    row = sheet.createRow((short) rowIndex);
    if (rowIndex == 0) {
     cell = row.createCell(0);
     cell.setCellValue("CatA");
     for (int colIndex = 1; colIndex < 32; colIndex++) {
      cell = row.createCell((short) colIndex);
      cell.setCellValue(colIndex + (colIndex-1)*11);
     }
    } else if (rowIndex == 1) {
     cell = row.createCell(0);
     cell.setCellValue("ValA");
     for (int colIndex = 1; colIndex < 32; colIndex++) {
      cell = row.createCell((short) colIndex);
      cell.setCellValue(new java.util.Random().nextDouble() * 8 + 1);
     }
    } else if (rowIndex == 2) {
     cell = row.createCell(0);
     cell.setCellValue("CatB");
     for (int colIndex = 1; colIndex < 14; colIndex++) {
      cell = row.createCell((short) colIndex);
      cell.setCellValue(colIndex);
     }
    } else if (rowIndex == 3) {
     cell = row.createCell(0);
     cell.setCellValue("ValB");
     for (int colIndex = 1; colIndex < 14; colIndex++) {
      cell = row.createCell((short) colIndex);
      cell.setCellValue(new java.util.Random().nextDouble() * 8 + 1);
     }
    }
   }

   // creata anchor
   XSSFDrawing drawing = sheet.createDrawingPatriarch();
   XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 15, 25);

   // create chart
   XSSFChart chart = drawing.createChart(anchor);

   // create data sources
   XDDFDataSource<Double> cat1 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(0, 0, 1, 31));
   XDDFNumericalDataSource<Double> val1 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(1, 1, 1, 31));
   XDDFDataSource<Double> cat2 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(2, 2, 1, 13));
   XDDFNumericalDataSource<Double> val2 = XDDFDataSourcesFactory.fromNumericCellRange(sheet, new CellRangeAddress(3, 3, 1, 13));

   // first line chart

   // create axis
   XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
   XDDFValueAxis rightAxis = chart.createValueAxis(AxisPosition.RIGHT);
   rightAxis.setCrosses(AxisCrosses.MAX);

   // create data and series
   XDDFLineChartData data = (XDDFLineChartData) chart.createData(ChartTypes.LINE, bottomAxis, rightAxis);
   XDDFLineChartData.Series series = (XDDFLineChartData.Series) data.addSeries(cat1, val1);
   series.setTitle("CatA", new CellReference(sheet.getSheetName(), 0, 0, true, true));
   series.setSmooth(false);
   series.setMarkerStyle(MarkerStyle.NONE);

   chart.plot(data);

   solidLineSeries(data, 0, PresetColor.BLUE);

   // second line chart

   // create axis
   XDDFCategoryAxis topAxis = chart.createCategoryAxis(AxisPosition.TOP);
   topAxis.setCrosses(AxisCrosses.MAX);
   rightAxis = chart.createValueAxis(AxisPosition.RIGHT);
   rightAxis.setVisible(false); // right axis must be there but can be invisible
   rightAxis.setCrosses(AxisCrosses.MAX);

   // set correct cross axis
   topAxis.crossAxis(rightAxis);
   rightAxis.crossAxis(topAxis);

   // create data and series
   data = (XDDFLineChartData) chart.createData(ChartTypes.LINE, topAxis, rightAxis);
   series = (XDDFLineChartData.Series) data.addSeries(cat2, val2);
   series.setTitle("CatB", new CellReference(sheet.getSheetName(), 2, 0, true, true));
   series.setSmooth(false);
   series.setMarkerStyle(MarkerStyle.NONE);

   chart.plot(data);

   // correct the id and order, must not be 0 again because there is a series already in the other chart
   chart.getCTChart().getPlotArea().getLineChartArray(1).getSerArray(0).getIdx().setVal(1);
   chart.getCTChart().getPlotArea().getLineChartArray(1).getSerArray(0).getOrder().setVal(1);

   solidLineSeries(data, 0, PresetColor.GREEN);

   // create legend
   XDDFChartLegend legend = chart.getOrAddLegend();
   legend.setPosition(LegendPosition.BOTTOM);
   legend.setOverlay(false);

   // Write the output to a file
   try (FileOutputStream fileOut = new FileOutputStream("ooxml-line-chart.xlsx")) {
    wb.write(fileOut);
   }
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
}