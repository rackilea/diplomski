mTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        final TableColumnModel columnModel = mTable.getColumnModel();
        for (int column = 0; column < mTable.getColumnCount(); column++) {
            int width = 50; // Min width
            for (int row = 0; row < mTable.getRowCount(); row++) {
                TableCellRenderer renderer = mTable.getCellRenderer(row, column);
                Component comp = mTable.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width, width);
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }