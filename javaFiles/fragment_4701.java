viewer.addSelectionChangedListener(new ISelectionChangedListener() {
    @Override
    public void selectionChanged(final SelectionChangedEvent event) {
        if (!event.getSelection().isEmpty()) {
             v.setSelection(StructuredSelection.EMPTY);
        }
    }
});