PseudoClass specialClass = PseudoClass.getPseudoClass("special");

nameColumn.setCellFactory(tc -> new TextFieldTableCell<MyType, String>(TextFormatter.IDENTITY_STRING_CONVERTER) {
    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        boolean condition = /* depends on item and empty.... */
        pseudoClassStateChanged(specialClass, condition);
    }
});