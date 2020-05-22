@Override
public void start(Stage primaryStage) throws IllegalAccessException {
    VBox container = new VBox();
    final List<CheckBox> selectionOrder = new ArrayList<>();
    final int checkBoxCount = 4;

    for (int i = 0; i < checkBoxCount; i++) {
        final CheckBox cb = new CheckBox();
        cb.setUserData(i);
        cb.selectedProperty().addListener((o, oldValue, newValue) -> {
            if (newValue) {
                selectionOrder.add(cb);
            } else {
                selectionOrder.remove(cb);
            }
        });
        container.getChildren().add(cb);
    }

    Button btn = new Button("print");
    btn.setOnAction(evt -> {
        System.out.println(selectionOrder.stream().map(c -> c.getUserData().toString()).collect(Collectors.joining(", ", "{ ", " }")));
        // print binary
        int value = 0;
        for (CheckBox cb : selectionOrder) {
            value |= (1 << ((Integer) cb.getUserData()));
        }
        System.out.println(value);
    });

    container.getChildren().add(btn);

    Scene scene = new Scene(container);
    primaryStage.setScene(scene);
    primaryStage.show();
}