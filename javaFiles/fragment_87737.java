textField.textProperty().addListener((ob, oldValue, newValue) -> {
     if (isNumeric(newValue)) {
         textField.setStyle("");
     } else {
         textField.setStyle("-fx-control-inner-background: red");
     }
});