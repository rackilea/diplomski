textArea.setTextFormatter(new TextFormatter<String>(change -> {
    String text = change.getText();
    if (!text.isEmpty()) {
        change.setText(text.replace('\u0004', '\u02e9')); // replace eot char with "valid" one
    }
    return change;
}));