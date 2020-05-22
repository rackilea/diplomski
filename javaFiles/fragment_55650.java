@Override
public void start(Stage primaryStage) {
    final VBox root = new VBox();
    final Scene sc = new Scene(root);
    primaryStage.setScene(sc);

    final TilePane tp = new TilePane();
    tp.setPrefTileWidth(200);
    tp.setPrefTileHeight(200);
    root.getChildren().add(tp);

    tp.setPrefColumns(3);
    tp.setAlignment(Pos.TOP_LEFT);
    tp.setStyle("-fx-background-color: green;");
    root.setAlignment(Pos.CENTER);
    root.setFillWidth(false);

    // set prefColumns from a listener instead of a binding
    // to prevent the initial value from being set to 0
    root.widthProperty().addListener((o, oldValue, newValue) -> {
        // allow as many columns as fit the parent but keep it in
        // range [1, childCount]
        tp.setPrefColumns(Math.min(tp.getChildren().size(),
                Math.max(1, (int) (newValue.doubleValue() / tp.getPrefTileWidth()))));
    });

    Stream.iterate(0, i -> i + 1).limit(5).forEach(i -> {
        Region r = new Region();
        r.setStyle("-fx-background-color: red; -fx-border-color: blue; -fx-border-width: 1;");

        tp.getChildren().add(r);
    });

    primaryStage.show();
}