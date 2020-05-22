TextArea ta = new TextArea();
final KeyCombination keyCombCtrZ = new KeyCodeCombination(KeyCode.Z, KeyCombination.SHORTCUT_DOWN;
final KeyCombination keyCombCtrY = new KeyCodeCombination(KeyCode.Y, KeyCombination.SHORTCUT_DOWN);
ta.setOnKeyPressed(new EventHandler<KeyEvent>() {

    @Override
    public void handle(KeyEvent event) {
        if (keyCombCtrZ.match(event) || keyCombCtrY.match(event) ) { 
            event.consume();
        }

    }
});