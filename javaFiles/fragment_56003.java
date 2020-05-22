public LiveLineChart(Timeline animation, Axis<Number> xAxis, Axis<Number> yAxis) {
    super(xAxis, yAxis);
    // ...
}

public LiveLineChart(Timeline animation, Axis<Number> xAxis, Axis<Number> yAxis, ObservableList<Series<Number, Number>> data) {
    super(xAxis, yAxis, data) ;
    // ...
}