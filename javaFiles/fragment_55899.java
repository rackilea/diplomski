public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    Table table = new Table(shell, SWT.NONE);
    table.setHeaderVisible(true);

    for(int col = 0; col < 3; col++)
    {
        TableColumn column = new TableColumn(table, SWT.NONE);
        column.setText("Column " + col);
    }

    Color color = display.getSystemColor(SWT.COLOR_YELLOW);

    for(int row = 0; row < 10; row++)
    {
        TableItem item = new TableItem(table, SWT.NONE);

        for(int col = 0; col < 3; col++)
        {
            item.setText(col, "Item " + row + " Column " + col);

            if(col == 1)
            {
                item.setBackground(col, color);
            }
        }
    }

    for(int col = 0; col < 3; col++)
    {
        table.getColumn(col).pack();
    }

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}