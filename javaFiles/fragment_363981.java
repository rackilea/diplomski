public class TestClass
{
    private static int counter = 0;

    public static void main(String[] args)
    {
        Display display = Display.getDefault();
        Shell shell = new Shell(display);

        shell.setLayout(new FillLayout());

        /* These are the text fields */
        final Text textOne = new Text(shell, SWT.BORDER);
        final Text textTwo = new Text(shell, SWT.BORDER);
        final Text textThree = new Text(shell, SWT.BORDER);

        /* Save them in an arraylist */
        final ArrayList<Text> textFields = new ArrayList<Text>();
        textFields.add(textOne);
        textFields.add(textTwo);
        textFields.add(textThree);

        /* save their position as well (not optimal, you can think of an easier method) */
        final HashMap<Text, Integer> textFieldsMapping = new HashMap<Text, Integer>();
        textFieldsMapping.put(textOne, 0);
        textFieldsMapping.put(textTwo, 1);
        textFieldsMapping.put(textThree, 2);

        /* Define keylistener which takes care of using . as tab */
        KeyListener keyListener = new KeyListener() {

            @Override
            public void keyReleased(KeyEvent arg0) {
            }

            @Override
            public void keyPressed(KeyEvent arg0) {
                /* if '.' pressed */
                if(arg0.character == '.')
                {
                    /* ignore this action */
                    arg0.doit = false;

                    /* get next text field */
                    Text next = textFields.get(counter);

                    /* force focus on this text field */
                    next.setFocus();
                    next.forceFocus();
                }
            }
        };

        /* Define focuslistener which sets current position */
        FocusListener focusListener = new FocusListener() {

            @Override
            public void focusLost(FocusEvent arg0) {
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                /* get current text field */
                Text current = (Text)arg0.getSource();

                /* get current position */
                int currentPosition = textFieldsMapping.get(current);

                /* set counter to next text field */
                counter = (currentPosition + 1) % textFields.size();
            }
        };

        /* add keylistener to text fields */
        textOne.addKeyListener(keyListener);
        textTwo.addKeyListener(keyListener);
        textThree.addKeyListener(keyListener);

        /* add focuslistener to text fields */
        textOne.addFocusListener(focusListener);
        textTwo.addFocusListener(focusListener);
        textThree.addFocusListener(focusListener);

        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
}