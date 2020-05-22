public class Main extends Application {
    Stage window;
    Scene[] scenes = new Scene[2];

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        Button b1 = makeButton("Go to s2", 1);
        Button b2 = makeButton("Go to s1", 0);

        scenes[0] = new Scene(b1);
        scenes[1] = new Scene(b2);

        primaryStage.setScene(scenes[0]);
        primaryStage.show();
    }

    public Button makeButton(String name, int destScene)  {
        Button button = new Button(name);
        button.setOnAction(e -> window.setScene(scenes[destScene]));
        return button;
    }
}