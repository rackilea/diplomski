viewer.addSelectionChangedListener(new ISelectionChangedListener() {

    private boolean update;

    private ISelection lastSelection;

    @Override
    public void selectionChanged(SelectionChangedEvent event) {
        if (event.getSelection().isEmpty() && !update) {
            update = true;
            v.setSelection(lastSelection);
            update = false;
        } else if (!event.getSelection().isEmpty()) {
            lastSelection = event.getSelection();
        }

    }
});