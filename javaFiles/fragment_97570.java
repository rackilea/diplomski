table.setModel(new DefaultTableModel(new String[][] { } , new String[] {"Time", "Description"} ) );
JFormattedTextField ftext = new JFormattedTextField();
MaskFormatter mask;
try {
    mask = new MaskFormatter("##:##");
    mask.install(ftext);
} catch (ParseException e) {
    e.printStackTrace();
}
table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(ftext));