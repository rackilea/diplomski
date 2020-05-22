@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    setOpaque(true);//adding this line I solved my problem
    setBackground(isSelected ? new Color(83,142,213) : Color.white);
    setForeground(isSelected ? Color.white : Color.black);
    setText(value != null ? value.toString() : "<null>");
    return this;
}