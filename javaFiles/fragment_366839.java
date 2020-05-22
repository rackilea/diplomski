public void selectionChanged(final SelectionChangedEvent event) {
    Object selection = ((StructuredSelection) event.getSelection()).getFirstElement();
    if (selection != null) {
        boolean state = !checkboxTreeViewer.getChecked(selection);
        checkboxTreeViewer.setChecked(selection, state);
        checkboxTreeViewer.setSelection(StructuredSelection.EMPTY);
        checkStateListener.checkStateChanged(new CheckStateChangedEvent((ICheckable) event.getSource(), selection,
            state));
    }

}