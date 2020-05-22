public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(2, false));

    final Label label = new Label(shell, SWT.NONE);

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Click me!");
    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            label.setText(label.getText() + " test");
            label.getParent().layout();
        }
    });

    shell.pack();
    shell.setSize(400, 300);
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}