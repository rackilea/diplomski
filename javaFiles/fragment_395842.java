private void addNodesToUI(VBox mainBox) {
    final int[] i = {0};

    Accordion temp = new Accordion();

    Platform.runLater(() -> {
        mainBox.getChildren().add(temp);
    });

    while (i[0] < 5000) {
        TitledPane tp = new TitledPane();
        tp.setPrefWidth(300);
        tp.setPrefHeight(12);
        tp.setPadding(new Insets(10));
        tp.setStyle("-fx-background-color: red;");

        i[0]++;

        Platform.runLater(() -> {
            temp.getPanes().add(tp);
        });
    }
}