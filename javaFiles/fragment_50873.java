JCheckBox checkBox = new JCheckBox();
checkBox.setHorizontalAlignment(JCheckBox.CENTER);
checkBox.setSelectedIcon( selectedIcon );
checkBox.setIcon( icon );
DefaultCellEditor dce = new DefaultCellEditor( checkBox );
table.getColumnModel().getColumn(???).setCellEditor(dce);