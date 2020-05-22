box.setButtonCell(new ListCell<String>() {
    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            setText(item);
            setAlignment(Pos.CENTER_RIGHT);
            Insets old = getPadding();
            setPadding(new Insets(old.getTop(), 0, old.getBottom(), 0));
        }
    }
});