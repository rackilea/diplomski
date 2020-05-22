private void addSeriesListener(BooleanProperty selected, final XYChart.Series series) {
    selected.addListener((observable, wasSelected, isSelected) -> {
        if (isSelected) {
            chart.getData().add(series);
        } else {
            chart.getData().remove(series);
        }
    });
}
. . .
addSeriesListener(heartRateCheck.selectedProperty(), heartRateSeries);
addSeriesListener(cadenceCheck.selectedProperty(), cadenceSeries);
addSeriesListener(speedCheck.selectedProperty(), speedSeries);