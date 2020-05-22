public static void main(String[] args)
{
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(2, true));
    shell.setText("ExpandBar Example");

    Composite ltr = new Composite(shell, SWT.LEFT_TO_RIGHT);
    ltr.setLayout(new GridLayout(3, true));
    ltr.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    Composite rtl = new Composite(shell, SWT.RIGHT_TO_LEFT);
    rtl.setLayout(new GridLayout(3, true));
    rtl.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    for(int i = 0; i < 10; i++)
    {
        new Button(ltr, SWT.PUSH).setText("Button " + i);
        new Button(rtl, SWT.PUSH).setText("Button " + i);
    }

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
    display.dispose();
}