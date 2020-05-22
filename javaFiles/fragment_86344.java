public static void main(String[] args) {

    Display display = new Display();

    Shell shell = new Shell(display);
    shell.setSize(300, 150);
    shell.setLayout(new GridLayout());

    CCombo combo = new CCombo(shell, 0);
    combo.setItems(new String[] { "String 1", "Test", "StackOverflow"});

    combo.addSelectionListener(selectionAdapter);
    combo.addFocusListener(focusAdapter);

    CCombo combo2 = new CCombo(shell, 0);
    combo2.setItems(new String[] { "String 1", "Test", "StackOverflow"});

    combo2.addSelectionListener(selectionAdapter);
    combo2.addFocusListener(focusAdapter);

    shell.open();
    while (!shell.isDisposed()) {
        if (!shell.getDisplay().readAndDispatch()) {
            shell.getDisplay().sleep();
        }
    }
}

static void selectionAtEnd(CCombo c) {
    // get the length of the selected item
    String text = c.getText();
    int endSelection = text.length();

    // set the cursor at the end of the text
    c.setSelection(new Point(endSelection, endSelection));
}

static SelectionAdapter selectionAdapter = new SelectionAdapter() {
    @Override
    public void widgetSelected(SelectionEvent arg0) {
        // change selection when an item is selected
        selectionAtEnd((CCombo) arg0.getSource());
    }   
};

static FocusAdapter focusAdapter = new FocusAdapter() {
    @Override
    public void focusGained(FocusEvent arg0) {
        // change selection when focus is gained
        selectionAtEnd((CCombo) arg0.getSource());
    }
};