public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(5, true));

    for (int i = 0; i < 30; i++)
    {
        Button button = new Button(shell, SWT.PUSH);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        button.addListener(SWT.Selection, e -> button.setText(UUID.randomUUID().toString().substring(0, 10)));
    }

    shell.pack();
    shell.open();
    shell.setSize(600, 300);

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
    display.dispose();
}