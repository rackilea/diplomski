column1.setCellEditor(new DefaultCellEditor(combo1) {
        @SuppressWarnings("unchecked")
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {

            // the items that will fill our JComboBox. Initially its empty
            Object[] items = new Object[]{};

            // get the value in the column to the left
            Object column0Value = table.getValueAt(row, column - 1);
            if (column0Value != null) {
                // if the value is not null, then get the map's values
                // and use it to fill our items array
                items = dataMap.get(column0Value).toArray();
            } 

            // get the super component, the JComboBox that is being used
            // as an editor:
            JComboBox<Object> superCombo = (JComboBox<Object>) super.getTableCellEditorComponent(table, value, isSelected,
                    row, column);

            // create a model and fill with items
            DefaultComboBoxModel<Object> comboModel = new DefaultComboBoxModel<>(items);

            // set the cell editor's model and return
            superCombo.setModel(comboModel);
            return superCombo;
        }
    });