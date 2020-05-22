StringConverter<String> converter =  ... ;
column.setCellFactory(col -> {
    TextFieldTableCell<Item, String> cell = new TextFieldTableCell<>(converter);
    validate(validationRules, cell);
    return cell ;
});