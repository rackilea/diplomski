public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    Locale.setDefault(Locale.GERMAN);
    CDateTime cdt = new CDateTime(shell, CDT.DATE_SHORT);
    cdt.setSelection(new Date());

    Locale.setDefault(Locale.ENGLISH);
    cdt = new CDateTime(shell, CDT.DATE_SHORT);
    cdt.setSelection(new Date());

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}