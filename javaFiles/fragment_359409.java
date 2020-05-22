int visibleRows = model.getRowCount();
visibleRows = Math.max(1, visibleRows);
visibleRows = Math.min(maxVisibleRows, visibleRows);

Dimension size = table.getPreferredScrollableViewportSize();
size.height = table.getRowHeight() * visibleRows;
table.setPreferredScrollableViewportSize(size);