public static void main(String[] args)
{
    Display display = new Display();
    final Image image = display.getSystemImage(SWT.ICON_INFORMATION);
    Shell shell = new Shell(display);
    shell.setText("Images on the right side of the TableItem");
    shell.setLayout(new FillLayout());
    Table table = new Table(shell, SWT.MULTI | SWT.FULL_SELECTION);
    table.setHeaderVisible(true);
    table.setLinesVisible(true);
    int columnCount = 3;
    for (int i = 0; i < columnCount; i++)
    {
        TableColumn column = new TableColumn(table, SWT.NONE);
        column.setText("Column " + i);
    }
    int itemCount = 8;
    for (int i = 0; i < itemCount; i++)
    {
        TableItem item = new TableItem(table, SWT.NONE);
    }
    /*
     * NOTE: MeasureItem, PaintItem and EraseItem are called repeatedly.
     * Therefore, it is critical for performance that these methods be
     * as efficient as possible.
     */
    Listener paintListener = event ->
    {
        switch (event.type)
        {
            case SWT.MeasureItem:
            {
                Rectangle rect1 = image.getBounds();
                event.width += rect1.width;
                event.height = Math.max(event.height, rect1.height + 2);
                break;
            }
            case SWT.PaintItem:
            {
                TableItem item = (TableItem) event.item;
                Rectangle rect2 = image.getBounds();
                Rectangle bounds = item.getBounds(event.index);
                int x = bounds.x + bounds.width - rect2.width;
                int offset = Math.max(0, (event.height - rect2.height) / 2);
                event.gc.drawImage(image, x, event.y + offset);
                break;
            }
        }
    };
    table.addListener(SWT.MeasureItem, paintListener);
    table.addListener(SWT.PaintItem, paintListener);

    for (int i = 0; i < columnCount; i++)
    {
        table.getColumn(i).pack();
    }
    shell.setSize(500, 200);
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch()) display.sleep();
    }
    if (image != null) image.dispose();
    display.dispose();
}