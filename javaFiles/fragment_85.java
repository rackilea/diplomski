private class ComboBoxRenderer extends DefaultListCellRenderer {

    private static final long serialVersionUID = 1L;
    private Font baseFont = new JLabel("Test").getFont();

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {

        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
              setFont(new Font("Courier", Font.ITALIC, 14));
    
        return this;
    }
}