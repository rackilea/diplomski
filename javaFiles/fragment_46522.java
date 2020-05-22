String week = "";
boolean colorSwitch = false;

for (ExcelRow row : printOutRows) {
    if (!row.getExcelCells().get(0).getExcelCell().getRichStringCellValue().getString().equals(week)){
        week = row.getExcelCells().get(0).getExcelCell().getRichStringCellValue().getString();
        colorSwitch = !colorSwitch;
    }

    model.addRow(new Object[] {
        colorSwitch,
        row.getExcelCells().get(0).getExcelCell().getRichStringCellValue().getString(),
        row.getExcelCells().get(1).getExcelCell().getRichStringCellValue().getString(),
        row.getExcelCells().get(2).getExcelCell().getRichStringCellValue().getString(),
        row.getExcelCells().get(3).getExcelCell().getNumericCellValue()
   });  

}

// remove first column from the view (the one with the boolean value in it)      
TableColumnModel tcm = table.getColumnModel();
tcm.removeColumn( tcm.getColumn(0) );

// render the table according to the color.      
table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

        if ((Boolean) table.getModel().getValueAt(row, 0)) {
            setBackground(Color.BLACK);
            setForeground(Color.WHITE);
        } else {
            setBackground(table.getBackground());
            setForeground(table.getForeground());
        }       

        return this;
    }   
  });