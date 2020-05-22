root.setOnMouseClicked(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
        System.out.println(event.getSceneX());
        System.out.println(event.getSceneY());
    }
});