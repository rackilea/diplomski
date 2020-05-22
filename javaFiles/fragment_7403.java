public class NoBug {

  static void plot(Chart chart, int n) {

    chart.setChartTitle("title");
    chart.setXAxisTitle("X");
    chart.setYAxisTitle("Y");
    List<Number> x = new ArrayList<Number>();
    List<Number> y = new ArrayList<Number>();
    String seriesName = addOneSeries(chart, n, x, y);
  }

  private static String addOneSeries(Chart chart, int n, List<Number> x, List<Number> y) {

    for (int i = 0; i <= 10; i++) {
      x.add(i / 10.);
      y.add(i * n / 10.);
    }
    String seriesName = "series " + n;
    Series series = chart.addSeries(seriesName, x, y);
    chart.getStyleManager().setxAxisMin(0);
    chart.getStyleManager().setxAxisMax(1);
    chart.getStyleManager().setyAxisMin(-5);
    chart.getStyleManager().setyAxisMax(5);
    return seriesName;
  }

  public static void main(String[] args) {

    for (int i = 0; i < 4; i++) {
      Chart chart = new LineChart(700, 500);
      plot(chart, i);
      new SwingWrapper(chart).displayChart();
    }
  }

}