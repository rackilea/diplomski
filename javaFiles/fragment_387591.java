listViewOfWords.setCellFactory(param -> new ListCell<Word>() {
    @Override
    protected void updateItem(Word item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null || item.getWord() == null) {
            setText(null);
        } else {
            setText(item.getWord());
        }
    }
});