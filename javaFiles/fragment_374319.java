comboBox.setCellFactory(param -> new ComboBoxListCell<String>() {{
    setTextFill(Color.WHITE);

    Background blackBackground = new Background(new BackgroundFill(Color.BLACK, null, null));
    Background greenBackground = new Background(new BackgroundFill(Color.GREEN, null, null));

    setBackground(blackBackground);
    setOnMouseEntered(event -> {
        setBackground(greenBackground);
    });
    setOnMouseExited(event -> {
        setBackground(blackBackground);
    });
}});