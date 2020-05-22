private static int        columns = 3;
private static List<Text> texts   = new ArrayList<>();

public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(columns, false));

    Table table = new Table(shell, SWT.FULL_SELECTION);
    table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, columns, 1));
    table.setHeaderVisible(true);

    /* Create columns */
    for (int col = 0; col < columns; col++)
    {
        new TableColumn(table, SWT.NONE).setText("Col " + col);
    }

    /* Create cells */
    for (int row = 0; row < 10; row++)
    {
        TableItem item = new TableItem(table, SWT.NONE);

        for (int col = 0; col < table.getColumnCount(); col++)
        {
            item.setText(col, "Cell " + row + " " + col);
        }
    }

    /* Pack columns */
    for (int col = 0; col < table.getColumnCount(); col++)
    {
        table.getColumn(col).pack();
    }

    /* Create the Text fields */
    for (int col = 0; col < columns; col++)
    {
        Text text = new Text(shell, SWT.BORDER);
        texts.add(text);
    }

    /* Listen for selection */
    table.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            Table table = (Table) e.widget;
            TableItem item = table.getItem(table.getSelectionIndex());

            /* Fill the texts */
            for (int col = 0; col < table.getColumnCount(); col++)
            {
                texts.get(col).setText(item.getText(col));
            }
        }
    });

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}