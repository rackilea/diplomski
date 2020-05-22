table.getColumn("Name").setCellRenderer(
            new DefaultTableCellRenderer() {

        Color originalColor = null;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (originalColor == null) {
                originalColor = getForeground();
            }
            if (value == null) {
                renderer.setText("");
            } else {
                renderer.setText(value.toString());
            }

            if (row == 3) {
                renderer.setForeground(Color.RED);
            } else {
                renderer.setForeground(originalColor); // Retore original color
            }
            return renderer;
        }
    });