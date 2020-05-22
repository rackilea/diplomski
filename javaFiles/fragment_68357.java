private static Region createRegion(String color) {
    Region region = new Region();
    region.setStyle("-fx-background-color: "+color);
    return region;
}

@Override
public void start(Stage primaryStage) {
    VBox vbox = new VBox(
            createRegion("red"),
            createRegion("blue"),
            createRegion("green")
    );
    for (Node n : vbox.getChildren()) {
        VBox.setVgrow(n, Priority.ALWAYS);
    }

    Scene scene = new Scene(vbox);

    primaryStage.setScene(scene);
    primaryStage.show();
}