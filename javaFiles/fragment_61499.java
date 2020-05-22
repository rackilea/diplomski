Table table = new Table(parent, SWT.NONE);
TableViewer tableViewer = new TableViewer(table);

table.setData("tableViewer", tableViewer);

table.addListener(SWT.DISPOSE, new Listener() {
    public void handleEvent(Event e)
    {
        Table table = (Table)e.widget;
        TableViewer tableViewer = (TableViewer)table.getData("tableViewer");
    }
});