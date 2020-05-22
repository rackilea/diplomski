double spinnerWidth = calculateWidth("123", spnr.getEditor()) + upArrow.getWidth();

 private double calculateWidth(String value, TextField textField) {
        Text text = new Text(value);
        text.setFont(textField.getFont());
        Insets insets = textField.getInsets();
        return insets.getLeft() + text.prefWidth(-1) + insets.getRight();
    }