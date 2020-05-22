column.setCellFactory(col -> {
    return new TableCell<Foo, Boolean>() {
        final CheckBox checkBox = new CheckBox();

        @Override
        public void updateItem(final Boolean selected, final boolean empty) {
            super.updateItem(selected, empty);

            if (!this.isEmpty()) {
                setGraphic(checkBox);
                setText("");
            }
            else {
                setGraphic(null); // Remove checkbox if row is empty
                setText("");
            }
        }
    }
}