import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.xddf.usermodel.chart.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.CellRangeAddress;

public class WordChangeChartDataPieOrDoughnut {

 public static void main(String[] args) throws Exception {

  String filePath = "TEMP_Chart_Simple.docx"; // has template chart having 1 series, 4 categories
  String filePathNew = "New_Chart_Simple.docx";

  Object[][] data = new Object[][] { // 1 series, 4 categories
   {"", "Clothing sales"}, // series titles
   {"Trousers", 123d}, // category 1
   {"Shirt", 345d}, // category 2
   {"Skirt", 180d}, // category 3
   {"Blouse", 180d} // category 4
  };

  XWPFDocument document = new XWPFDocument(new FileInputStream(filePath));

  XWPFChart chart = document.getCharts().get(0);
  XSSFWorkbook chartDataWorkbook = chart.getWorkbook();
  String sheetName = chartDataWorkbook.getSheetName(0);
  XSSFSheet chartDataSheet = chartDataWorkbook.getSheet(sheetName);

  XDDFChartData chartData = null;
  if (chart.getChartSeries().size() == 1) { // only one chart data
   chartData = chart.getChartSeries().get(0); // pie chart or other supported chart
  } else if (chart.getCTChart().getPlotArea().getDoughnutChartList().size() == 1) { // only one doughnut chart data
   chartData = new XDDFDoughnutChartData(chart.getCTChart().getPlotArea().getDoughnutChartList().get(0)); //doughnut chart
  }

  if (chartData != null) { 
   if (chartData.getSeries().size() == 1) { // exact one series

    int rMin = 1;
    int rMax = 4;

    // set new category data
    XDDFCategoryDataSource category = null;
    int c = 0;
    for (int r = rMin; r < rMax+1; r++) {
     chartDataSheet.getRow(r).getCell(c).setCellValue((String)data[r][c]); // in sheet
    }
    category = XDDFDataSourcesFactory.fromStringCellRange(chartDataSheet, new CellRangeAddress(rMin,rMax,c,c)); // in chart

    // series 1
    XDDFChartData.Series series1 = chartData.getSeries().get(0);
    c = 1;
    // set new title
    String series1Title = (String)data[0][c];
    chartDataSheet.getRow(0).getCell(c).setCellValue(series1Title); // in sheet
    chartDataSheet.getTables().get(0).getCTTable().getTableColumns().getTableColumnList().get(c).setName(series1Title);
    if (chartDataSheet.getTables().size() > 0) {
     if (chartDataSheet.getTables().get(0).getCTTable().getTableColumns().getTableColumnList().size() > c)
      chartDataSheet.getTables().get(0).getCTTable().getTableColumns().getTableColumnList().get(c).setName(series1Title);
    }
    series1.setTitle(series1Title, new CellReference(sheetName, 0, c, true, true)); // in chart

    // set new values
    XDDFNumericalDataSource<Double> values = null;
    for (int r = rMin; r < rMax+1; r++) {
     chartDataSheet.getRow(r).getCell(c).setCellValue((Double)data[r][c]); // in sheet
    }
    values = XDDFDataSourcesFactory.fromNumericCellRange(chartDataSheet, new CellRangeAddress(rMin,rMax,c,c)); 
    series1.replaceData(category, values);
    series1.plot(); //in chart

   }
  }

  FileOutputStream out = new FileOutputStream(filePathNew); 
  document.write(out);
  out.close();
  document.close();
 }

}