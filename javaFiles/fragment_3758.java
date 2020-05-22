UnaryOperator<TextFormatter.Change> filter = c -> {
    if (c.getCaretPosition() < prefix.length() || c.getAnchor() < prefix.length()) {
        return null ;
    } else {
        return c ;
    }
};

textField.setTextFormatter(new TextFormatter<String>(filter));