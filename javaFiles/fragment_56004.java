public class LiveLineChartBuilder {
    private Axis<Number> xAxis ;
    private Axis<Number> yAxis ;
    private Timeline animation ;
    private ObservableList<Series<Number,Number>> data ;

    public static LiveLineChartBuilder create() {
        return new LiveLineChartBuilder();
    }

    public LiveLineChartBuilder xAxis(Axis<Number> xAxis) {
        this.xAxis = xAxis ;
        return this ;
    }

    public LiveLineChartBuilder yAxis(Axis<Number> yAxis) {
        this.yAxis = yAxis ;
        return this ;
    }

    public LiveLineChartBuilder animation(Timeline animation) {
        this.animation = animation ;
        return this ;
    }

    public LiveLineChartBuilder data(Series<Number, Number> data) {
        this.data = data ;
        return this ;
    }

    public LiveLineChart build() {
        // if else may not be necessary, depending on how you define constructors in LiveLineChart
        if (data == null) {
            return new LiveLineChart(animation, xAxis, yAxis);
        } else {
            return new LiveLineChart(animation, xAxis, yAxis, data);
        }
    }
}