comboBox.getEditor().focusedProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                 if (comboBox.getSelectionModel().getSelectedIndex() < 0) {
                     comboBox.getEditor().setText(null);
                 }
            }
        });