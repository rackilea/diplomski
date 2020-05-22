jComboBox.setUI(new BasicComboBoxUI() {
    @Override
    protected ComboPopup createPopup() {
        BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
        basicComboPopup.setBorder(new LineBorder(Color.RED));
        return basicComboPopup;
    }
});