ComboBox<SampleDTO> comboBox = new ComboBox<SampleDTO>(store, label);
    comboBox.addKeyUpHandler(new KeyUpHandler() {
    @Override
    public void onKeyUp(KeyUpEvent event) {
        store.setUserText(comboBox.getText());
    }
});