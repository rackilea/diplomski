public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    String[][] radioButtonOptions = new String[][] { { "Button1", "button1" }, { "Button2", "button2" } };

    final RadioGroupFieldEditor radioButtonGroup = new RadioGroupFieldEditor("PrefValue", "Choose Button1 or Button2", 2, radioButtonOptions, shell, true);

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Deselect");

    button.addListener(SWT.Selection, new Listener() {

        @Override
        public void handleEvent(Event arg0) {
            Composite temp = radioButtonGroup.getRadioBoxControl(shell);
            Control[] children = temp.getChildren();

            for(Control child : children)
            {
                if(child instanceof Button)
                {
                    ((Button)child).setSelection(false);
                }
            }
        }
    });


    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}