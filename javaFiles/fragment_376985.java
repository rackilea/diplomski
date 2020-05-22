private void newLineOnSemiColonPress() {
    InputMap input = editor.getInputMap();
    String INSERT_BREAK = "insert-break";
    KeyStroke semi = KeyStroke.getKeyStroke("released SEMICOLON");
    input.put(semi, INSERT_BREAK);
}