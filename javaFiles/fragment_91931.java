public ColumnGenerator table_getGeneratedColumn(String tableName, final FVTableColumn tableColumn) {
    ColumnGenerator columnGenerator = null;
    if (    tableColumn != null 
            &&  tableColumn.getName() != null
            &&  tableColumn.getName().equals("PRINT_BUTTON")) {

        columnGenerator = new ColumnGenerator() {
            @Override
            public Object generateCell(Table source, Object itemId, Object columnId) {
                Button button = new Button("Print");
                button.addClickListener(new ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        Globals.showNotification("Button Clicked", "The print button has been licked", IFocEnvironment.TYPE_HUMANIZED_MESSAGE);
                    }
                });
                return button;
            }
        };

    }           
    return columnGenerator;
}