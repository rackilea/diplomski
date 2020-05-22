class MyListRenderer extends JLabel implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Object[] itemData = (Object[])value;
        setText((String)itemData[1]);

        return this;
    }
}