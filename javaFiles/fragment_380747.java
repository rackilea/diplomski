public class LineChartWithMarkers<X extends Number, Y extends Number> extends LineChart<X, Y>  {

    private ObservableList<Data<Number, Number>> verticalMarkers;


    public LineChartWithMarkers(
            @NamedArg("xAxis") Axis<X> xAxis, 
            @NamedArg("yAxis") Axis<Y> yAxis) {
        super(xAxis, yAxis);
        this.setCreateSymbols(false);
        verticalMarkers = FXCollections.observableArrayList(data -> new Observable[] {data.XValueProperty()});
        verticalMarkers.addListener((InvalidationListener)observable -> layoutPlotChildren());
    }
    (...)
}