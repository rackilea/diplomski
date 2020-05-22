private static void addFocusListener(TextField field, Consumer<? super String> setter) {
    field.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {}
        @Override
        public void focusLost(FocusEvent e) {
            setter.accept(field.getText());
        }
    });
}