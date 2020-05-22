public class SwingFx extends Application {

    @Override
    public void start(Stage stage) {
        // create pane with SwingNode
        final SwingNode swingNode = new SwingNode();
        createAndSetSwingContent(swingNode);
        StackPane paneWithSwing = new StackPane(swingNode);

        // create invisible pane to initialize SwingPane in Scene
        Pane invisiblePane = new Pane(paneWithSwing);
        invisiblePane.setPrefWidth(0);
        invisiblePane.setPrefHeight(0);
        invisiblePane.setOpacity(0);

        // create Scene without visible SwingPane
        Button button = new Button("Set SwingNode");
        button.setOnAction(event -> {
            invisiblePane.getChildren().clear();
            stage.getScene().setRoot(paneWithSwing);
        });
        StackPane originalPane = new StackPane(invisiblePane, button);
        stage.setScene(new Scene(originalPane, 320, 180));
        stage.show();
    }

    private void createAndSetSwingContent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(() -> swingNode.setContent(new JButton("Click me!")));
    }

    public static void main(String[] args) {
        launch(args);
    }
}