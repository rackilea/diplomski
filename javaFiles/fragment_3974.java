public static void main(final String[] args) {

    // ...

    new Label(s, SWT.NONE).setText("C");
    final Button c = new Button(s, SWT.CHECK);

    new Label(s, SWT.NONE).setText("L1");
    final MyButton b = new MyButton(s, "Button 1");

    // ...

    c.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(final SelectionEvent e) {
            b.setEnabled(!b.isEnabled());
        }
    });

    // ...

}