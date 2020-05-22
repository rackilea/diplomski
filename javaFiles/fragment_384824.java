targetVBox.setOnMouseDragReleased(event -> {
    targetVBox.getChildren().add(sourceDisk);

    // reset translate values
    sourceDisk.setTranslateX(0);
    sourceDisk.setTranslateY(0);
});