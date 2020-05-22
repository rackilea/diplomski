public static void main(String[] args)
{
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));
    shell.setText("StackOverflow");

    final Table table = new Table(shell, SWT.BORDER | SWT.MULTI);
    table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    for (int i = 0; i < 10; i++)
    {
        TableItem item = new TableItem(table, SWT.NONE);
        item.setText("item " + i);
    }

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Color selected");

    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            List<TableItem> allItems = new ArrayList<>(Arrays.asList(table.getItems()));
            TableItem[] selItems = table.getSelection();

            for (TableItem item : selItems)
            {
                item.setForeground(display.getSystemColor(SWT.COLOR_RED));
                allItems.remove(item);
            }

            for (TableItem item : allItems)
            {
                item.setForeground(display.getSystemColor(SWT.COLOR_LIST_FOREGROUND));
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