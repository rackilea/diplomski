public static void main(String[] args)
{
    Display display = Display.getDefault();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout(SWT.VERTICAL));

    final Text path = new Text(shell, SWT.BORDER);
    Button fileChooser = new Button(shell, SWT.PUSH);
    fileChooser.setText("Browse...");

    fileChooser.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            FileDialog dialog = new FileDialog(shell);

            String filePath = dialog.open();

            if(filePath != null)
                path.setText(filePath);
        }
    });

    shell.pack();
    Point size = shell.computeSize(SWT.DEFAULT, SWT.DEFAULT);
    shell.setSize(400, size.y);
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}