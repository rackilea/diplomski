import java.io.*;

import org.apache.poi.xwpf.usermodel.*;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.Units;

import org.apache.poi.xddf.usermodel.*;
import org.apache.poi.xddf.usermodel.chart.*;

public class CreateWordXDDFChartTwoLinesInTable {

 public static void main(String[] args) throws Exception {
  try (XWPFDocument document = new XWPFDocument()) {

   // create the data
   String[] categories = new String[]{"1","2","3","4","5","6","7","8","9"};
   Double[] values1 = new Double[]{1d,2d,3d,4d,5d,6d,7d,8d,9d};
   Double[] values2 = new Double[]{200d,300d,400d,500d,600d,700d,800d,900d,1000d};

   // create the chart
   // this also puts the chart into a run in a new created paragraph
   XWPFChart chart = createChart(document, categories, values1, values2);
   // remove the first paragraph since we need the chart being elsewhere
   document.removeBodyElement(0);

   XWPFParagraph paragraph = document.createParagraph();
   XWPFRun run = paragraph.createRun();
   run.setText("First paragraph having first text run.");

   // create the table
   XWPFTable table = document.createTable(1,2);
   table.setWidth("100%");
   // create first run in first table cell
   paragraph = table.getRow(0).getCell(0).getParagraphArray(0);
   run = paragraph.createRun();
   // attach the chart here
   java.lang.reflect.Method attach = XWPFChart.class.getDeclaredMethod("attach", String.class, XWPFRun.class);
   attach.setAccessible(true);
   attach.invoke(chart, document.getRelationId(chart), run);
   chart.setChartBoundingBox(7*Units.EMU_PER_CENTIMETER, 7*Units.EMU_PER_CENTIMETER);

   // set text in second table cell
   paragraph = table.getRow(0).getCell(1).getParagraphArray(0);
   run = paragraph.createRun();
   run.setText("Other text goes in the 2");
   run = paragraph.createRun();
   run.setSubscript(VerticalAlign.SUPERSCRIPT);
   run.setText("nd");
   run = paragraph.createRun();
   run.setText(" cell.");

   paragraph = document.createParagraph();
   run = paragraph.createRun();
   run.setText("Lorem ipsum...");

   // Write the output to a file
   try (FileOutputStream fileOut = new FileOutputStream("CreateWordXDDFChartTwoLinesInTable.docx")) {
    document.write(fileOut);
   }
  }
 }

 private static XWPFChart createChart(XWPFDocument document, 
   String[] categories, Double[] values1, Double[] values2) throws Exception {

   // create the chart
   XWPFChart chart = document.createChart();

   // create data sources
   int numOfPoints = categories.length;
   String categoryDataRange = chart.formatRange(new CellRangeAddress(1, numOfPoints, 0, 0));
   String valuesDataRange1 = chart.formatRange(new CellRangeAddress(1, numOfPoints, 1, 1));
   String valuesDataRange2 = chart.formatRange(new CellRangeAddress(1, numOfPoints, 2, 2));
   XDDFDataSource<String> categoriesData = XDDFDataSourcesFactory.fromArray(categories, categoryDataRange, 0);
   XDDFNumericalDataSource<Double> valuesData1 = XDDFDataSourcesFactory.fromArray(values1, valuesDataRange1, 1);
   XDDFNumericalDataSource<Double> valuesData2 = XDDFDataSourcesFactory.fromArray(values2, valuesDataRange2, 2);

   // first line chart
   XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
   XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
   leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
   XDDFChartData data = chart.createData(ChartTypes.LINE, bottomAxis, leftAxis);
   XDDFChartData.Series series = data.addSeries(categoriesData, valuesData1);
   chart.plot(data);

   solidLineSeries(data, 0, PresetColor.BLUE);

   // second line chart
   // bottom axis must be there but must not be visible
   bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
   bottomAxis.setVisible(false);

   XDDFValueAxis rightAxis = chart.createValueAxis(AxisPosition.RIGHT);
   rightAxis.setCrosses(AxisCrosses.MAX);

   // set correct cross axis
   bottomAxis.crossAxis(rightAxis);
   rightAxis.crossAxis(bottomAxis);

   data = chart.createData(ChartTypes.LINE, bottomAxis, rightAxis);
   series = data.addSeries(categoriesData, valuesData2);
   chart.plot(data);

   // correct the id and order, must not be 0 again because there is one line series already
   chart.getCTChart().getPlotArea().getLineChartArray(1).getSerArray(0).getIdx().setVal(1);
   chart.getCTChart().getPlotArea().getLineChartArray(1).getSerArray(0).getOrder().setVal(1);

   solidLineSeries(data, 0, PresetColor.RED);

   return chart;
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