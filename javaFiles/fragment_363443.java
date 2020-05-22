Stage newStage = new Stage();
StackPane stack = new StackPane();
ImageView imageView = new ImageView(new Image(...));
stack.getChildren().add(imageView);

class DragHandler implements EventHandler<MouseEvent> {

    Stage dragTarget;

    @Override
    public void handle(MouseEvent event) {
        if (dragTarget != null) {
            // move stage
            dragTarget.setX(event.getScreenX());
            dragTarget.setY(event.getScreenY());
            event.consume();
        }
    }

}

final DragHandler dragHandler = new DragHandler();

imageView.setOnDragDetected(event -> {
    // init stage at half transparency
    Group root = new Group(new ImageView(imageView.getImage())); 
    root.setOpacity(0.5);

    Scene displayScene = new Scene(root);
    displayScene.setFill(null);
    Stage displayStage = new Stage();
    displayStage.initStyle(StageStyle.TRANSPARENT);
    displayStage.setScene(displayScene);
    displayStage.setX(event.getScreenX());
    displayStage.setY(event.getScreenY());
    displayStage.show();

    dragHandler.dragTarget = displayStage;

    event.consume();
});
imageView.setOnMouseDragged(dragHandler);
imageView.setOnMouseReleased(event -> {
    if (dragHandler.dragTarget != null) {
        if (stack.contains(event.getX(), event.getY())) { // check, if drop happened inside the bounds of the scene root
            dragHandler.dragTarget.hide();
        } else {
            // make stage fully opaque & cleanup
            dragHandler.dragTarget.getScene().getRoot().setOpacity(1);
            imageView.setImage(null);
        }
        dragHandler.dragTarget = null;
        event.consume();
    }
});

Scene scene = new Scene(stack, 500, 500);
newStage.setScene(scene);
newStage.show();