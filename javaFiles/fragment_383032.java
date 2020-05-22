public class Main extends Application{

    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage=primaryStage;
        AnchorPane page = (AnchorPane) FXMLLoader.load(MainController.class.getResource("mainFXML.fxml"));

        Scene scene = new Scene(page);

        primaryStage.setTitle("Fade example");
        primaryStage.setScene(scene);

        // Stage positioning
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        // stage positioning
        primaryStage.setX(primaryScreenBounds.getMaxX()*5/8);
        primaryStage.setY(primaryScreenBounds.getMinY() + page.getPrefHeight()*2/4);

        primaryStage.show();

    }

    public static void main(String[] args) {

        launch(args);
    }
}