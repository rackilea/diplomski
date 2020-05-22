public class FXStages extends Application {

    private int counter = 0;

    @Override
    public void start(final Stage stage) {
        Button btn = new Button();
        btn.setText("Reopen");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                stage.close();
                Stage newStage = new Stage();
                newStage.setX(stage.getX());
                newStage.setY(stage.getY());
                start(newStage);
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 250);
        stage.setTitle("Stage " + counter++);
        stage.setScene(scene);

        stage.show();
    }
}