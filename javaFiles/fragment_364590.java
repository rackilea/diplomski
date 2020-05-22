public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);

    shell.setLayout(new FillLayout());

    Text text = new Text(shell, SWT.BORDER);

    Listener listener = new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            System.out.println("Event");
        }
    };

    text.addListener(SWT.KeyUp, listener);
    text.addListener(SWT.MouseUp, listener);

    shell.pack();
    shell.open();

    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    display.dispose(); 
}