@FXML
private VBox somePane ; // can be any kind of Pane, fx:id in fxml matches variable name
// ...

// in some handler method (or initialize):
final DatePicker datePicker = new DatePicker(LocalDate.now());
datePicker.setOnAction(...);
somePane.getChildren().add(datePicker);