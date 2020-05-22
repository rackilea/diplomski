public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new MainPane(stage)));
        stage.show();
    }