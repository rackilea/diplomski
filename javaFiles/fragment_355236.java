if (e.getSource() == numberButtons[i]) {
        if (clearOnKeyPress || field.getText().equals("0")) {
            field.setText(""):
            clearOnKeyPress = false;
        }
        field.setText(field.getText() + i);
    }