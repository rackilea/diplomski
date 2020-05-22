Image image = new Image(getClass().getResourceAsStream("play3.jpg"));
button.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        Button button = (Button) e.getSource();
        button.setGraphic(new ImageView(image));
    }
});