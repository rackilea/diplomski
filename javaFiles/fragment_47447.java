public void addSelectionListener (SelectionListener listener) {
    checkWidget();
    if (listener == null) error(SWT.ERROR_NULL_ARGUMENT);
    TypedListener typedListener = new TypedListener(listener);
    addListener(SWT.Selection, typedListener);
    addListener(SWT.DefaultSelection, typedListener);
}