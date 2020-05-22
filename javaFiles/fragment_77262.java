class Cell{
   ...
   String text;
   boolean isHighlighted;
   ...
}

class MyTableCellRenderer implements TableCellRenderer{
    // cellLabel will be used to render each cell. Note that
    // this component is re-used for painting each cell, we
    // don't have separate instances for all cells.
    private JLabel cellLabel=new JLabel();

    @Override
    public Component getTableCellRendererComponent(
        JTable table,
        Object value,
        boolean isSelected,
        boolean hasFocus,
        int row,
        int column) {

        Cell cell=(Cell)value;
        cellLabel.setText(cell.getText());
        if(cell.isHighlighted)
            cellLabel.setForeground(Color.RED);
    }    
}