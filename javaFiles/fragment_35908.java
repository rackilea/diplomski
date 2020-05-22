ListCell<File> buttonCell = new ListCell<File>() {
    @Override
    protected void updateItem(File item, boolean empty) {
        super.updateItem(item, empty);
        setText(empty ? null : item.getName());
    }
};
buttonCell.setTextOverrun(OverrunStyle.LEADING_ELLIPSIS);
fileComboBox.setButtonCell(buttonCell);