input.setChangeListener(new FieldChangeListener() {
    public void fieldChanged(Field field, int context) {
        if (context != FieldChangeListener.PROGRAMMATIC) {
            input.setText(pruebaTexto(input.getText()));
        }
    }
});