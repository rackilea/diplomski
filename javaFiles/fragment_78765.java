.....

Tab tabA = new Tab();

Label tabALabel = new Label("Main Component");
tabA.setGraphic(tabALabel);

tabALabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
            if (mouseEvent.getClickCount() == 2) {

                mainPane.setPrefSize(500, 500); //Your required size

            }
       }
    }
});

....