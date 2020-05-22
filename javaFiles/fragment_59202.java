public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    FocusListener focusListener = new FocusListener()
    {
        @Override
        public void focusLost(FocusEvent e)
        {
            System.out.println("Focus out: " + e.widget.getData());
        }

        @Override
        public void focusGained(FocusEvent e)
        {
            System.out.println("Focus in: " + e.widget.getData());
        }
    };

    Text text = new Text(shell, SWT.BORDER);
    text.setText("Text");
    text.setData("Text");
    text.addFocusListener(focusListener);

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Button");
    button.setData("Button");
    button.addFocusListener(focusListener);

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}