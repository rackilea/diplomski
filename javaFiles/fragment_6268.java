taInput.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
    @Override
    public void handle(KeyEvent e) {
        if (e.getCode() == KeyCode.TAB) {
            String s = StringUtils.repeat(' ', config.getTabSpacesCount());
            taInput.insertText(taInput.getCaretPosition(), s);
            e.consume();
        }
    }
});