public class Example extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    GridPane gridTop = new GridPane();
    GridPane gridBottom = new GridPane();
    VBox mainPanel = new VBox(gridTop, gridBottom);

    Label topLabel = new Label("Top");
    gridTop.add(topLabel, 0, 0);
    Button createAnchorPane = new Button("Create AnchorPane");
    gridBottom.add(createAnchorPane, 0, 0);

    createAnchorPane.setOnAction(event -> {
      Label centerLabel = new Label("Center");
      AnchorPane newPane = new AnchorPane();
      newPane.getChildren().add(centerLabel);
      // add the anchor pane in the middle
      mainPanel.getChildren().add(1, newPane);
    });

    Scene scene = new Scene(mainPanel, 400, 400);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}