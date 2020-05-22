class SuperScatterChart extends ScatterChart<Number, Number>{

    private final ImageView iv1 ;

    public SuperScatterChart(NumberAxis xAxis, NumberAxis yAxis) {
        super(xAxis, yAxis);
        iv1 = new ImageView(new Image("file:///C:/Desktop/cie.png",450,450,true,true));
        getPlotChildren().add(iv1);
    }

}