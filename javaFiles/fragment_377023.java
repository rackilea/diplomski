final Button btnConfirm = new Button(shell, SWT.CHECK);

btnConfirm.addSelectionListener(new SelectionAdapter()
{
    @Override
    public void widgetSelected(SelectionEvent e)
    {
        if (btnConfirm.getSelection())
            setPageComplete(true);
        else
            setPageComplete(false);
    }
});