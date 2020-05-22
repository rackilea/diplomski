public static void main(String[] args)
{
    final Display display = new Display();

    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout(SWT.VERTICAL));

    final Text normal = new Text(shell, SWT.BORDER);
    final Text special = new Text(shell, SWT.BORDER);
    special.addListener(SWT.KeyUp, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            normal.setText(special.getText());
            special.redraw();
        }
    });

    special.addListener(SWT.Paint, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            if (!special.isEnabled())
            {
                GC gc = e.gc;

                String text = special.getText();
                Rectangle bounds = special.getBounds();

                gc.setBackground(display.getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND));
                gc.setForeground(display.getSystemColor(SWT.COLOR_TITLE_FOREGROUND));
                gc.fillRectangle(0, 0, bounds.width, bounds.height);
                gc.drawText(text, 3, 2);
            }
        }
    });

    normal.setEnabled(false);

    Button switchButton = new Button(shell, SWT.PUSH);
    switchButton.setText("(De)activate");
    switchButton.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            special.setEnabled(!special.getEnabled());
        }
    });

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
}