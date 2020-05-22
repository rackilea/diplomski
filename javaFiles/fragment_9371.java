StackPane root = new StackPane();
root.getChildren().add(viewer);
Node processingCanvas = stage.getScene().getRoot().getChildrenUnmodifiable().get(0);
root.getChildren().add(processingCanvas);
Scene scenes = new Scene(root, 1100, 618, Color.TRANSPARENT);
stage.setScene(scenes);