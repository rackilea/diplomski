......
//Set x/y Axis Label
xAxis.setLabel(xLabel);
yAxis.setLabel(yLabel);
//THIS CHECKS TO SEE IF A CHART IS ADDED AND REMOVES IT TO PREVENT
//DUPLICATING THE CHART
if(grid.getChildren().size() == 3){
    grid.getChildren().remove(2);

}
        //creating the chart
final LineChart<Number,Number> lineChart = new LineChart<>(xAxis,yAxis);
        lineChart.setTitle(gTitle);

//defining a series
XYChart.Series series = new XYChart.Series();
series.setName("My portfolio");
//populating the series with data
series.getData().add(new XYChart.Data(1, 23));
series.getData().add(new XYChart.Data(2, 14));
series.getData().add(new XYChart.Data(3, 15));
series.getData().add(new XYChart.Data(4, 24));
series.getData().add(new XYChart.Data(5, 34));
series.getData().add(new XYChart.Data(6, 36));
grid.getChildren().add(lineChart);  //Add linechart to grid
lineChart.getData().add(series);


});