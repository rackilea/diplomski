public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("Stackoverflow");
    shell.setLayout(new FillLayout());

    TableCombo tc = new TableCombo(shell, SWT.BORDER | SWT.READ_ONLY);

    Image image = display.getSystemImage(SWT.ICON_ERROR);

    for (int i = 0; i < 10; i++)
    {
        TableItem ti = new TableItem(tc.getTable(), SWT.NONE);
        ti.setText("Item " + i);
        ti.setImage(image);
    }

    shell.pack();
    shell.open();

    shell.setCursor(display.getSystemCursor(SWT.CURSOR_IBEAM));

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}