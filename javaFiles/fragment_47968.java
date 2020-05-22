public class Main extends Application {

    private Image mainImage;
    private final Group selectionGroup = new Group();

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Basic stage settings
        primaryStage.setTitle("Picture Viewer");
        primaryStage.setResizable(true);

        // Set task bar primary icon
        primaryStage.getIcons().add(new javafx.scene.image.Image("main/react-app-icon.png"));

        // Declare UI variables
        final BorderPane borderPane = new BorderPane();
        final ScrollPane scrollPane = new ScrollPane();
        final Scene scene = new Scene(borderPane, 800, 600);

        ImageView mainImageView = new ImageView();

        // Select main layout file
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("/main/scene.fxml"));
        loader.setController(new MainController(primaryStage, selectionGroup, mainImage, mainImageView));
        Parent root = loader.load();

        // Add custom stylesheet URL
        scene.getStylesheets().add("main/style.css");

        // Set UI element properties
        selectionGroup.getChildren().add(mainImageView);
        scrollPane.setContent(selectionGroup);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        borderPane.setCenter(scrollPane);
        borderPane.setTop(root);

        // Show primary stage
        primaryStage.setScene(scene);
        // primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}