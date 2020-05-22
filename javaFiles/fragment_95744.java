private boolean marked;

Label label = new Label("Marked: " + marked)
controls.getChildren().setAll(
            highlightButton,
            markedButton,
            label
);