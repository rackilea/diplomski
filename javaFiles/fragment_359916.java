TextField textField = new TextField();
textField.setTextFormatter(new TextFormatter<String>((Change change) -> {
    String newText = change.getControlNewText();
    if (newText.length() > 1) {
        return null ;
    } else {
        return change ;
    }
});