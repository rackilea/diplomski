public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 400, 400);

            HBox hbox = new HBox();
            hbox.getChildren().add(createRadioLabel("Radio on the left", ContentDisplay.LEFT));
            hbox.getChildren().add(createRadioLabel("Radio on the top", ContentDisplay.TOP));
            hbox.getChildren().add(createRadioLabel("Radio on the bottom", ContentDisplay.BOTTOM));
            hbox.getChildren().add(createRadioLabel("Radio on the right", ContentDisplay.RIGHT));
            hbox.setSpacing(30);
            root.setCenter(hbox);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Label createRadioLabel(String text, ContentDisplay cd) {
        Label label = new Label(text);
        label.setGraphic(new RadioButton());
        label.setContentDisplay(cd);
        label.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            RadioButton radioButton = (RadioButton) ((Label) e.getSource()).getGraphic();
            radioButton.requestFocus();
            radioButton.setSelected(!radioButton.isSelected());

        });
        return label;
    }


    public static void main(String[] args) {
        launch(args);
    }
}