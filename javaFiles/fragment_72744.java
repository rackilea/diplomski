// Add generic parameters (uses the <> operator on the right)
XYChart.Series<Number, Number> series = new XYChart.Series<>();
series.setName("Temp Res graph");
for(int i = 1; i<800; i++) {
    // Add generic parameters (uses the <> operator on the right)
    XYChart.Data<Number, Number> dp = new XChart.Data<>(i,Integer.parseInt(getTemp(i)));
    series.getData().add(dp);
}
lineChart.getData().add(series); // outside loop