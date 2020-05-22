tree.addSelectionListener(new SelectionAdapter() {
    @Override
    public void widgetSelected(final SelectionEvent e) {
        tree.setSelection(tree.getSelection());
    }
});