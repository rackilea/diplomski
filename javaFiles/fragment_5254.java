TextArea textArea = new TextArea();
textArea.setOnKeyTyped(e -> {
    if (e.getCharacter().equals("k")) {
        e.consume();
    }
});