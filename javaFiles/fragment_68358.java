@Override
public void start(Stage primaryStage) throws IOException {
    GridPane root = new GridPane();

    root.getColumnConstraints().addAll(DoubleStream.of(30, 2, 68)
            .mapToObj(width -> {
                ColumnConstraints constraints = new ColumnConstraints();
                constraints.setPercentWidth(width);
                constraints.setFillWidth(true);
                return constraints;
            }).toArray(ColumnConstraints[]::new));

    RowConstraints rowConstraints = new RowConstraints();
    rowConstraints.setVgrow(Priority.ALWAYS);

    root.getRowConstraints().add(rowConstraints);

    root.addRow(0, Stream.of("red", "green", "blue").map(s -> createRegion(s)).toArray(Node[]::new));

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);

    primaryStage.show();
}