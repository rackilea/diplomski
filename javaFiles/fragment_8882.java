public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell();

    shell.pack();
    shell.open();
    shell.setBounds(0, 0, 100, 100);

    Shell childOne = new Shell(shell);
    childOne.pack();
    childOne.open();
    childOne.setBounds(0, 100, 100, 100);

    Shell childTwo = new Shell(SWT.DIALOG_TRIM);
    childTwo.pack();
    childTwo.open();
    childTwo.setBounds(0, 200, 100, 100);

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
    display.dispose();
}