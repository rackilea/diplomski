public EditableCell() {
        setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                commitEdit(textfield.getText());
            }
        });
    }