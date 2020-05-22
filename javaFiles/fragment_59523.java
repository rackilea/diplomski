Button button = (Button) getDialogPane().lookupButton(ButtonType.OK);

button.addEventFilter(ActionEvent.ACTION, event -> {
    final Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.initOwner(window);
    alert.showAndWait().ifPresent(response -> {
        if (response == ButtonType.CANCEL) {
            event.consume();
        }
    });
});