public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Select file");

    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            /* Create the dialog */
            FileDialog dialog = new FileDialog(shell, SWT.OPEN);

            /* Open it. The absolute path of the selected file will be saved in the String variable */
            String selection = dialog.open();

            /* If the user selected something, print it */
            if(selection != null)
                System.out.println(selection);
        }
    });

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