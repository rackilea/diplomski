public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    GridLayout layout = new GridLayout(3, false);
    layout.horizontalSpacing = 0;
    layout.verticalSpacing = 0;
    shell.setLayout(layout);

    createContent(new Composite(shell, SWT.BORDER), false);
    createContent(new Composite(shell, SWT.BORDER), true);
    createContent(new Composite(shell, SWT.BORDER), false);

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

private static void createContent(Composite parent, boolean hFill)
{
    if (hFill)
    {
        parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        parent.setLayout(new GridLayout(3, true));
    }
    else
    {
        parent.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, false, true));
        parent.setLayout(new GridLayout(1, true));
    }

    for (int i = 0; i < 6; i++)
    {
        new Button(parent, SWT.PUSH).setText("Button " + i);
    }
}