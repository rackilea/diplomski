importStatus.setCellFactory(tc -> new TableCell<Contact, Boolean>() {
    @Override
    protected void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty);
        setText(empty ? null :
            item.booleanValue() ? "imported" : "new");
    }
});