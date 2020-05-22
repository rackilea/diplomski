Button button =  new Button(shell, SWT.PUSH);
final String someString = "hello world!";
button.addSelectionListener(new SelectionAdapter() { 
    @Override
    public void widgetSelected(SelectionEvent e) {
        // Handle the selection event
        System.out.println(someString);
    }
});