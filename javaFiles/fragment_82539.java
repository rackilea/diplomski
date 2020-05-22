TableLayout layout = new TableLayout();

TableViewerColumn col = new TableViewerColumn(tableViewer, SWT.LEAD);

col.getColumn().setText("Text");

layout.addColumnData(new ColumnWeightData(100));

table.setLayout(layout);