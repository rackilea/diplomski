public class SlidoProgressBarDemo extends Application {

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Progress Controls");

        double sliderWidth = 200;

        final Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(50);
        slider.setMinWidth(sliderWidth);
        slider.setMaxWidth(sliderWidth);

        final ProgressBar pb = new ProgressBar(0);
        pb.setMinWidth(sliderWidth);
        pb.setMaxWidth(sliderWidth);

        final ProgressIndicator pi = new ProgressIndicator(0);

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                    Number old_val, Number new_val) {
                pb.setProgress(new_val.doubleValue() / 50);
                pi.setProgress(new_val.doubleValue() / 50);
            }
        });

        StackPane pane = new StackPane();

        pane.getChildren().addAll(pb, slider);

        final HBox hb = new HBox();
        hb.setSpacing(5);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(pane, pi);

        scene.setRoot(hb);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}