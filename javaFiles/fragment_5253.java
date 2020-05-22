TextArea textArea = new TextArea();
textArea.addEventFilter(KeyEvent.KEY_TYPED, e -> {
    if (e.getCharacter().equals("k")) {
        e.consume();
    }
});