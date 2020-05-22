...
XSSFChart chart = drawing.createChart(anchor);
...
XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
...
XDDFChartData data = chart.createData(ChartTypes.LINE, bottomAxis, leftAxis);
data.addSeries(...);
data.addSeries(...);
chart.plot(data);

if (chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).getTx() == null) 
 chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(0).addNewTx();
data.getSeries().get(0).setTitle("Series 1 Title", null);

if (chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(1).getTx() == null)
 chart.getCTChart().getPlotArea().getLineChartArray(0).getSerArray(1).addNewTx();
data.getSeries().get(1).setTitle("Series 2 Title", null);
...
//setting the axis Ids to the LineChart
chart.getCTChart().getPlotArea().getLineChartArray(0).addNewAxId().setVal(bottomAxis.getId());
chart.getCTChart().getPlotArea().getLineChartArray(0).addNewAxId().setVal(leftAxis.getId());
...