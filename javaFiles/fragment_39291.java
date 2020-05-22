public class ExtensionFilterExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("Extension Filter Example");

        final Label fileLabel = new Label();

        Button btn = new Button("Open FileChooser");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();

                // Set extension filter
                FileChooser.ExtensionFilter extFilter = 
                        new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);

                // Show open file dialog
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    fileLabel.setText(file.getPath());
                }
            }
        });

        VBox vBox = new VBox(30);
        vBox.getChildren().addAll(fileLabel, btn);
        vBox.setAlignment(Pos.BASELINE_CENTER);

        StackPane root = new StackPane();
        root.getChildren().add(vBox);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}