public static void main(String[] args) {
        final Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(1, true));

        TableViewer viewer1 = getViewer(shell);

        List<String> rows = new ArrayList<String>();
        rows.add("Row 1");
        rows.add("Row 2");

        viewer1.setInput(rows);

        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    private static TableViewer getViewer(final Shell shell) {
        TableViewer viewer = new TableViewer(shell, SWT.FULL_SELECTION
                | SWT.H_SCROLL | SWT.V_SCROLL | SWT.NONE);

        viewer.getTable().addListener(SWT.Resize, new Listener() {

          @Override
          public void handleEvent(Event event) {


            Table table = (Table)event.widget;
            int columnCount = table.getColumnCount();
            if(columnCount == 0)
              return;
            Rectangle area = table.getClientArea();
            int totalAreaWdith = area.width;
            int lineWidth = table.getGridLineWidth();
            int totalGridLineWidth = (columnCount-1)*lineWidth; 
            int totalColumnWidth = 0;
            for(TableColumn column: table.getColumns())
            {
              totalColumnWidth = totalColumnWidth+column.getWidth();
            }
            int diff = totalAreaWdith-(totalColumnWidth+totalGridLineWidth);

            TableColumn lastCol = table.getColumns()[columnCount-1];

//check diff is valid or not. setting negetive width doesnt make sense.
            lastCol.setWidth(diff+lastCol.getWidth());

          }
        });

        viewer.setContentProvider(ArrayContentProvider.getInstance());

        viewer.getTable().setLayoutData(
                new GridData(SWT.FILL, SWT.FILL, true, true));

        TableViewerColumn col = new TableViewerColumn(viewer, SWT.NONE);
        col.getColumn().setWidth(100);
        col.getColumn().setText("Text Column");
        col.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public void update(ViewerCell cell) {
                cell.setText((String) cell.getElement());
            }
        });

        col = new TableViewerColumn(viewer, SWT.NONE);
        col.getColumn().setWidth(100);
        col.getColumn().setText("Second Text Column");
        col.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public void update(ViewerCell cell) {
                cell.setText((String) cell.getElement());
            }
        });


        viewer.getTable().setHeaderVisible(true);

        return viewer;
    }