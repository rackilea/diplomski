IObservableList observableList = new WritableList();
observableList.addListChangeListener(new IListChangeListener() {

    @Override
    public void handleListChange(ListChangeEvent event) {
        System.out.println(event.diff);
    }
});
observableList.add("element");
observableList.add("element");
observableList.add("element");

TableViewer viewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL);
viewer.getTable().setHeaderVisible(true);
viewer.getTable().setHeaderVisible(true);
viewer.setContentProvider(new ObservableListContentProvider());

TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
column.getColumn().setText("Column");
column.getColumn().setWidth(200);

column.setLabelProvider(new ColumnLabelProvider());

// Provide the input to the ContentProvider
viewer.setInput(observableList);