public static void setupAutoComplete(final JTextField txtInput,final JTextField txtInput2, final ArrayList<String> items) {
        final DefaultComboBoxModel model = new DefaultComboBoxModel();
        final JComboBox cbInput = new JComboBox(model) {
            public Dimension getPreferredSize() {
                return new Dimension(super.getPreferredSize().width, 0);
            }
        };

        //The important line:
        cbInput.setFocusable(false);

        setAdjusting(cbInput, false);
        for (Object item : items) {
            model.addElement(item);
        }
        ...
}