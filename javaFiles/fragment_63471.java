import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xddf.usermodel.chart.*;

class ExcelChangeChartData {

 static void updateChartData(XSSFChart chart, XSSFSheet dataSheet, 
  int firstDataRow, int lastDataRow, int categoryColumn, int[] seriesColumns) {

  for (XDDFChartData chartData : chart.getChartSeries()) {
   for (int s = 0; s < chartData.getSeriesCount() ; s++) {
    XDDFChartData.Series series = chartData.getSeries(s);
    if (seriesColumns.length > s) {
     XDDFCategoryDataSource category = XDDFDataSourcesFactory.fromStringCellRange(
      dataSheet, new CellRangeAddress(firstDataRow, lastDataRow, categoryColumn, categoryColumn));
     int seriesColumn = seriesColumns[s];
     XDDFNumericalDataSource<Double> values = XDDFDataSourcesFactory.fromNumericCellRange(
      dataSheet, new CellRangeAddress(firstDataRow, lastDataRow, seriesColumn, seriesColumn));
     series.replaceData(category, values);  
     series.plot();
    }
   }
  }
 }

 public static void main(String[] args) throws Exception {

  String[] months = new String[]{"Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
  int firstDataRow = 1;
  int lastDataRow = 3;
  int categoryColumn = 0;
  int[] seriesColumns = new int[]{1,2,3};

  for (int m = 0; m < months.length - 1; m++) {
   String monthSource = months[m];
   String monthResult = months[m+1];
   String filePath = "./ExcelWithChart" + monthSource + ".xlsx";
   java.util.Random random = new java.util.Random();
   XSSFWorkbook workbook = (XSSFWorkbook)WorkbookFactory.create(new FileInputStream(filePath));
   XSSFSheet sheet = workbook.getSheetAt(0);
   XSSFRow row = sheet.createRow(lastDataRow + 1);
   XSSFCell cell = row.createCell(categoryColumn);
   cell.setCellValue(monthResult);
   for (int i = 0; i < seriesColumns.length; i++) {
    cell = row.createCell(seriesColumns[i]);
    cell.setCellValue(random.nextDouble() / 10 + 0.02);
    cell.setCellStyle(sheet.getRow(lastDataRow).getCell(seriesColumns[i]).getCellStyle());
   }
   lastDataRow++;

   XSSFDrawing drawing = sheet.createDrawingPatriarch();
   XSSFChart chart = drawing.getCharts().get(0);
   updateChartData(chart, sheet, firstDataRow, lastDataRow, categoryColumn, seriesColumns);

   filePath = "./ExcelWithChart" + monthResult + ".xlsx";
   FileOutputStream out = new FileOutputStream(filePath);
   workbook.write(out);
   out.close();
   workbook.close();
  }
 }
}