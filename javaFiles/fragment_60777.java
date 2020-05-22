public class SampleTask extends Application {

private BorderPane testPane;

class TestPane extends BorderPane {

    public TestPane() {
        Button button = new Button("Click Here");
        setCenter(button);
        button.setOnAction(evt -> {
            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        for (double progress = 0.0; progress < 100.0; progress++) {
                            Thread.sleep(100);
                            updateProgress(progress, 100);
                            System.out.println(progress);
                        }
                    } catch (InterruptedException e) {
                    }
                    return null;
                }
            };
            ProgressBar slider = startProgressBar();
            slider.progressProperty().bind(sleeper.progressProperty());
            Thread thread = new Thread(sleeper);
            thread.start();
        });
    }
}

public static void main(String[] args) {
    launch(args);
}

@Override
public void start(Stage primaryStage) {
    primaryStage.setTitle("Task Progress Tester");
    testPane = new TestPane();
    primaryStage.setScene(new Scene(testPane, 300, 250));
    primaryStage.show();
}

public ProgressBar startProgressBar() {
    Stage primaryStage = new Stage();
    ProgressBar pb = new ProgressBar(0);
    ProgressIndicator pi = new ProgressIndicator(0);
    pi.progressProperty().bind(pb.progressProperty());
    HBox hb = new HBox();
    hb.setSpacing(5);
    hb.setAlignment(Pos.CENTER);
    hb.getChildren().addAll(pb, pi);
    Scene scene = new Scene(hb, 300, 100);
    primaryStage.setScene(scene);
    primaryStage.show();
    return pb;
}