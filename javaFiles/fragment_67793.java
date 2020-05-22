@Override
public void start(Stage primaryStage) {
    VBox vbox = new VBox();
    for (int i = 0; i < 40; i++) {
        vbox.getChildren().add(new Text(Integer.toString(i)));
    }

    ScrollPane scrollPane = new ScrollPane(vbox);
    scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // never show a vertical ScrollBar
    scrollPane.setFitToWidth(true); // set content width to viewport width
    scrollPane.setPannable(true); // allow scrolling via mouse dragging

    primaryStage.setScene(new Scene(scrollPane, 300, 200));
    primaryStage.show();
}