private static final String INITIAL_TEXT = "Scheduler Info";

public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    final Text text = new Text(shell, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
    text.setEditable(false);
    text.setEnabled(false);
    text.setText(INITIAL_TEXT);

    Button replace = new Button(shell, SWT.PUSH);
    replace.setText("Replace");
    replace.addListener(SWT.Selection, new Listener()
    {
        private int counter = 1;
        @Override
        public void handleEvent(Event arg0)
        {
            String replace = INITIAL_TEXT;

            for(int i = 0; i < counter; i++)
                replace += "\nLine " + i;

            text.setText(replace);

            counter++;
        }
    });

    Button insert = new Button(shell, SWT.PUSH);
    insert.setText("Insert");
    insert.addListener(SWT.Selection, new Listener()
    {
        private int counter = 1;
        @Override
        public void handleEvent(Event arg0)
        {
            text.setSelection(INITIAL_TEXT.length(), text.getText().length());

            String newText = "";

            for(int i = 0; i < counter; i++)
                newText += "\nLine " + i;

            text.insert(newText);

            counter++;
        }
    });

    shell.pack();
    shell.setSize(shell.computeSize(SWT.DEFAULT, SWT.DEFAULT).x, 300);
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