public class Main extends Application {

    private final String IMAGE_PATH = "http://i.imgur.com/fcn1bFx.jpg";
    private final ObservableList<String> listOfImages = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {
        ScrollPane pane = new ScrollPane();
        VBox box = new VBox();
        box.setSpacing(10);
        box.setAlignment(Pos.CENTER);

        Button button = new Button("Add");
        button.setOnAction( e -> {
            listOfImages.add(IMAGE_PATH);
        });
        listOfImages.addListener((ListChangeListener<String>) c -> {
            c.next();
            if (c.wasAdded()) {
                box.getChildren().add(0, new ImageView(c.getAddedSubList().get(0)));
            }
        });
        box.heightProperty().addListener((ov, oldValue, newValue) -> {
            pane.setVvalue(pane.getVmax());
        });

        box.getChildren().add(button);
        pane.setContent(box);
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}