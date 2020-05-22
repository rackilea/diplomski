public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));
    shell.setText("StackOverflow");

    shell.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
    shell.setBackgroundMode(SWT.INHERIT_FORCE);

    new Button(shell, SWT.PUSH).setText("Button");
    new Label(shell, SWT.NONE).setText("Label");

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