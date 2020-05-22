public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(2, false));

    final TableViewer viewer = new TableViewer(shell, SWT.READ_ONLY);

    // First column is for the name
    TableViewerColumn col = createTableViewerColumn("Name", 100, 0, viewer);
    col.setLabelProvider(new ColumnLabelProvider() {
        @Override
        public String getText(Object element) {
            if(element instanceof Person)
            {
                System.out.println("1");
                return ((Person)element).getName();
            }
            return "";
        }
    });

    // First column is for the location
    TableViewerColumn col2 = createTableViewerColumn("Location", 100, 1, viewer);
    col2.setLabelProvider(new ColumnLabelProvider() {
        @Override
        public String getText(Object element) {
            if(element instanceof Person)
            {
                System.out.println("2");
                return ((Person)element).getLocation();
            }
            return "";
        }
    });

    final Table table = viewer.getTable();
    table.setHeaderVisible(true);
    table.setLinesVisible(true);
    GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
    data.horizontalSpan = 2;
    table.setLayoutData(data);

    /* This button will hide/unhide the columns */
    Button button1 = new Button(shell, SWT.PUSH);
    button1.setText("Hide / Unhide");

    button1.addListener(SWT.Selection, new Listener() {

        @Override
        public void handleEvent(Event arg0) {
            for(final TableColumn column : table.getColumns())
            {
                if(column.getWidth() == 0)
                {
                    column.setWidth(100);
                    column.setResizable(true);
                }
                else
                {
                    column.setWidth(0);
                    column.setResizable(false);
                }
            }
        }
    });

    /* This button will print the currently selected Person, even if columns are hidden */
    Button button2 = new Button(shell, SWT.PUSH);
    button2.setText("Print");

    button2.addListener(SWT.Selection, new Listener() {

        @Override
        public void handleEvent(Event arg0) {
            IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
            Person person = (Person) selection.getFirstElement();

            System.out.println(person);
        }
    });

    viewer.setContentProvider(ArrayContentProvider.getInstance());

    final Person[] persons = new Person[] { new Person("Baz", "Loc"),
            new Person("BazBaz", "LocLoc"), new Person("BazBazBaz", "LocLocLoc") };

    viewer.setInput(persons);

    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}

private static TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber, TableViewer viewer) {
    final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
    final TableColumn column = viewerColumn.getColumn();
    column.setText(title);
    column.setWidth(bound);
    column.setResizable(true);
    column.setMoveable(false);

    return viewerColumn;
}

public static class Person {
    private String name;
    private String location;

    public Person(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String toString()
    {
        return name + " " + location;
    }
}