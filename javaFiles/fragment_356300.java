XYChart chart;

if (chartClass.equals(LineChart.class))
    chart = new LineChart<Number, Number>(xAxis, yAxis);
else
    chart = new AreaChart<Number, Number>(xAxis, yAxis);

for (int i = 0; i < variablesToPlot.length; i++) {
    series[i] = new LineChart.Series<Number, Number>();

     // this chart must be LineChart or AreaChart (but not general chart) for getData() to work
    chart.getData().add(series[i]);  
}