protected void enableAccelerators() {
    accelerators = new HashMap<KeyCombination, Runnable>(pane.getScene().getAccelerators());
    for (KeyCombination combination : accelerators.keySet())
        accelerators.put(combination, null);
    pane.getScene().getAccelerators().put(new KeyCodeCombination(KeyCode.ENTER, KeyCombination.ALT_DOWN), new Runnable() {
        @Override
        public void run() {
            submit(null);
        }
    });
}