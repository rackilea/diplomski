public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, true));

    final Combo combo = new Combo(shell, SWT.NONE);

    combo.addListener(SWT.KeyUp, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            if(arg0.character == SWT.CR)
                MessageDialog.openInformation(shell, "Input", "You entered: " + combo.getText());
        }
    });

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}