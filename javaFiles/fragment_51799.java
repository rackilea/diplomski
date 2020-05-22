combo.setUI(new BasicComboBoxUI() {
    protected JButton createArrowButton() {
        return new JButton() {
            public int getWidth() {
                return 0;
            }
        };
    }
});