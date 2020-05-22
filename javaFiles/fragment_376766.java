private Label fieldLabel = new Label(shell, SWT.NONE);

public void testMethod()
{
    Button button = new Button(shell, SWT.PUSH);
    button.setText("Print");

    final Label finalLabel = new Label(shell, SWT.NONE);

    button.addListener(SWT.Selection, new Listener(){
        @Override
        public void handleEvent(Event e)
        {
            fieldLabel.setText("TEXT");
            finalLabel.setTexT("TEXT");
        }
    })
}