public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);

    /* SET LAYOUT */
    shell.setLayout(new FillLayout());
    shell.setText("Hello");
    JLabel lab = new JLabel("Hello World");
    Label username_checkout = new Label(shell, SWT.BOLD);
    username_checkout.setText("User Name");
    Button button = new Button(shell, SWT.PUSH);
    button.setText("push");
    shell.open();
    shell.pack();
    shell.setSize(270, 270);
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }

}