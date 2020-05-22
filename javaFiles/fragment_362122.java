public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));
    shell.setText("StackOverflow");

    Composite horizontal = new Composite(shell, SWT.NONE);
    horizontal.setLayout(new GridLayout(2, false));
    horizontal.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Composite left = new Composite(horizontal, SWT.BORDER);
    left.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Composite right = new Composite(horizontal, SWT.NONE);
    GridLayout layout = new GridLayout(1, false);
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    right.setLayout(layout);
    right.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Composite top = new Composite(right, SWT.BORDER);
    top.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Composite bottom = new Composite(right, SWT.BORDER);
    bottom.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    shell.pack();
    shell.setSize(600, 400);
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