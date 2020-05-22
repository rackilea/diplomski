ArrayList<Column> columns = getShownColumns();

for ( Column column : columns ) {
    TableColumn tableColumn = new TableColumn( table, column.getStyle() );
    tableColumn.setText( column.getTitle() );
    tableColumn.setWidth( column.getWidth() );
}