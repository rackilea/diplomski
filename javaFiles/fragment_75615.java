primaryStage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, e->{
    e.consume();
    Popup popup = new Popup();
    HBox buttons = new HBox();
    Button close = new Button("close");
    Button cancel = new Button("cancel");
    buttons.getChildren().addAll(close,cancel);
    buttons.setPadding(new Insets(5,5,5,5));
    popup.getContent().add(buttons);
    popup.show(primaryStage);
    close.setOnAction(ex -> {
        Platform.exit();
    });
    cancel.setOnAction(ec -> {
        popup.hide();
    });
});