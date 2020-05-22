@Override
public void start(Stage primaryStage) throws Exception {
    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();

    Group extraNodes = new Group();

    this.chart = new LineChart<Number, Number>(xAxis, yAxis) {
        @Override
        public void layoutPlotChildren() {
            super.layoutPlotChildren();
            Rectangle r1 = new Rectangle(0, 0, 50, 100);
            r1.setFill(Color.GREEN);
            Rectangle r2 = new Rectangle(70, 0, 30, 20);
            r2.setFill(Color.AQUAMARINE);
            extraNodes.getChildren().setAll(r1, r2);
            extraNodes.getTransforms().setAll(chartDisplayTransform(xAxis, yAxis));
            // note nodes don't get removed from the plot children, and this method may be
            // called often:
            if (!getPlotChildren().contains(extraNodes)) {
                getPlotChildren().add(extraNodes);
            }
        }
    };
    this.chart.setAnimated(false);

    VBox vbox = new VBox(this.chart);

    Scene scene = new Scene(vbox, 400, 200);
    primaryStage.setScene(scene);
    primaryStage.setHeight(600);
    primaryStage.setWidth(400);
    primaryStage.show();
}