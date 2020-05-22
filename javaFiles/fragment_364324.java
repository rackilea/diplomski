@FXML public void initialize () {
    name.textProperty().bind(Val.flatMap(city, City::nameProperty).orElseConst(""));
    name.disableProperty().bind(city.isNull());

    // ...
}