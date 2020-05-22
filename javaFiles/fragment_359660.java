mdTableModel = new ReadOnlyTableModel();

for (String col : columnNames) {
    mdTableModel.addColumn(col);
}

marketDataTable = new JTable(mdTableModel);
marketDataTable.setFillsViewportHeight(true);
marketDataTable.setToolTipText("Quotes");
marketDataTable.setBorder(null);
marketDataTable.setForeground(new Color(255, 215, 0));
marketDataTable.setBackground(UiColors.BACKGROUND_COLOR_DARK);
marketDataTable.setOpaque(false);