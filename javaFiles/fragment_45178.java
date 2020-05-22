final List<Row> rows = new ArrayList<>();

addTableField.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {             
        HBox box = new HBox(10);

        ComboBox<String> combo = new ComboBox<String>(fieldTypes);
        combo.setPromptText("type");

        TextField field = new TextField();
        field.setPromptText("field label");

        box.getChildren().addAll(field, combo);

        fieldContainer.getChildren().addAll(box);

        Row row = new Row();
        rows.add(row);
        row.labelProperty().bind(field.textProperty());
        row.typeProperty().bind(combo.valueProperty()); // might need to worry about null values...

        window.sizeToScene();
    }
});