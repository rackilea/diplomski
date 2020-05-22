listView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> p) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);

                            // decide to add a new styleClass
                            // getStyleClass().add("costume style");
                            // decide the new font size
                            setFont(Font.font(16));
                        }
                    }
                };
            }
        });