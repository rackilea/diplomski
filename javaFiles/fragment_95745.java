Label label=new Label("Marked: "+marked.get());
    HBox controls = new HBox(10);
    controls.setAlignment(Pos.CENTER_LEFT);
    controls.getChildren().setAll(
            highlightButton,
            markedButton,
            label
    );