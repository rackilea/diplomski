public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus, int row,
                    int column) {

    //.... your code

    setText(value != null ? value.toString() : ""); // suppress null values
    return this;
}