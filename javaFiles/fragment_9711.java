@Override
public void start(Stage primaryStage) throws Exception{
  BorderPane root1 = new BorderPane();
  BorderPane root2 = new BorderPane();
  primaryStage.setTitle("Hello World");

  Button nextStageButton = new Button("Go to Stage 2");
  root1.setCenter(nextStageButton);

  Scene scene =new Scene(root1, 300, 275);

  nextStageButton.setOnAction((event) -> {
    scene.setRoot(root2);
  });

  Button backStageButton = new Button("Go Back");
  root2.setCenter(backStageButton);


  backStageButton.setOnAction((event) -> {
    scene.setRoot(root1);
  });

  primaryStage.setScene(scene);
  primaryStage.show();
}