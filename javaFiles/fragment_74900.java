Button button = new Button(shell, SWT.PUSH);
button.addListener(SWT.Selection, new Listener()
{
    @Override
    public void handleEvent(Event event)
    {
        System.out.println("SWT.Selection");
    }
});