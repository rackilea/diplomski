public class Test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createChart());
        primaryStage.setScene(scene);
        primaryStage.setHeight(800);
        primaryStage.setWidth(1200);
        primaryStage.show();
    }

    private Parent createChart() {
        LineChart<Number, Number> lc = new LineChart<>(new NumberAxis(), new NumberAxis());
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        lc.getData().add(series);

        new Thread(() -> {
            try {
                Thread.sleep(5000);
                for (int i = 0; i < 15; i++) {
                    int finalI = i;
                    Platform.runLater(() -> series.getData().add(new XYChart.Data<>(1 + finalI, 1 + finalI)));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        return lc;
    }