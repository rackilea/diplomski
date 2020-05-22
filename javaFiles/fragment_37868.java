public void AnimatedChartApp extends Application {

    private AnimatedChart animatedChart ;

    @Override
    public void start(Stage primaryStage) {
        animatedChart = new AnimatedChart();
        Scene scene = new Scene(animatedChart.getView());
        primaryStage.setScene(scene);
        animatedChart.play();
        primaryStage.show();
    }

    @Override
    public void stop() {
        animatedChart.stop();
    }
}