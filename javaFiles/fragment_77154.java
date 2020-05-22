ListCell< Result > cell = new ListCell< Result >() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    setText(item.getValue());
                } else {
                    setText("");
                }
            }
        };