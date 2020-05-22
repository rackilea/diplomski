input.setChangeListener(new FieldChangeListener() {
    private boolean internalCall = false;
    public void fieldChanged(Field field, int context) {
        if (!internalCall) {
            internalCall = true;
            try {
                input.setText(pruebaTexto(input.getText()));
            }
            finally {
                internalCall = false;
            }
        }
    }
});