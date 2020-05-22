for (File selectedFile : selectedFiles) {
    HBox hBox = new HBox();

    Button removeButton = new Button("", new ImageView(new Image("/resources/images/minus-circle.png")));
    removeButton.setOnAction(evt -> {
        vbAttachment.getChildren().remove(hBox);
        // other code you need to execute when the button is pressed...
    });

    hBox.getChildren().addAll(
            new Label(selectedFile.getName() + " ( " + selectedFile.length() / 1024 + "Ko ) "),
            removeButton
    );
    vbAttachment.getChildren().add(hBox);
}