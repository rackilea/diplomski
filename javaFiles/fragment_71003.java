scene.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {

        if(event.getButton() == MouseButton.PRIMARY) {
            Circle circle = new Circle(event.getSceneX(), event.getSceneY(), 10, Color.DARKCYAN);
            circle.setOnMouseClicked(e  -> {
                if (e.getButton() == MouseButton.SECONDARY) {
                    root.getChildren().remove(circle);
                }
            });
            root.getChildren().add(circle);
        }               


    }
});