public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Not sure what this does, but you probably can't use it without some
        // modification.
        // scene = JavaFXUtils.createScene(1000, 600, "Main.fxml", this);

        // assuming path is correct:
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(loader.load(), 1000, 600);

        Controller controller = loader.getController();
        scene.addEventHandler(KeyEvent.KEY_PRESSED, controller::keyPressed);

        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/assets/resources/icon/icon_256.png")));
        primaryStage.setTitle("HWP");
        primaryStage.show();


    }

}