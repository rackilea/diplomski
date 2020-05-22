public class TestFxBase extends ApplicationTest {
    @Override
    public void start(Stage stage) {
        stage.setScene(new Scene(new MainPane(stage)));
        stage.show();
    }
}