public static void main(String[] args)
{
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(2, true));
    shell.setText("StackOverflow");

    Composite ltr = new Composite(shell, SWT.LEFT_TO_RIGHT);
    ltr.setLayout(new GridLayout(3, true));
    ltr.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    Composite rtl = new Composite(shell, SWT.LEFT_TO_RIGHT);
    rtl.setLayout(new GridLayout(3, true));
    rtl.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    int nrOfItems = 10;
    int nrOfColumns = ((GridLayout) rtl.getLayout()).numColumns;
    int fillerItems = nrOfColumns - nrOfItems % nrOfColumns;

    for (int i = 0; i < nrOfItems; i++)
    {
        new Button(ltr, SWT.PUSH).setText("Button " + i);
        new Button(rtl, SWT.PUSH).setText("Button " + i);
    }

    for(int i = 0; i < fillerItems; i++)
        new Label(rtl, SWT.NONE);

    Control[] children = rtl.getChildren();
    for (int i = 0; i < children.length; i++)
    {
        children[i].moveAbove(null);
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