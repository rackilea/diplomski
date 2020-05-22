Button btnConfirm = new Button(shell, SWT.CHECK);

btnConfirm.addSelectionListener(new SelectionAdapter()
{
    @Override
    public void widgetSelected(SelectionEvent e)
    {
        Button button = (Button) e.widget;
        if (button.getSelection())
            setPageComplete(true);
        else
            setPageComplete(false);
    }
});