box.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
    @Override
    public ListCell<String> call(ListView<String> list) {
        return new ListCell<String>() {
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    setText(item);
                    setAlignment(Pos.CENTER_RIGHT);
                    setPadding(new Insets(3, 3, 3, 0));
                }
            }
        };
    }
});