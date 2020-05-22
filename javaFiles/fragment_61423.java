combo.addListener(SWT.Selection, new Listener()
{
    @Override
    public void handleEvent(Event arg0)
    {
        String currentSelection = combo.getItem(combo.getSelectionIndex());

        if(currentSelection.equals(oldSelection))
        {
            // Same item selected
        }
        else
        {
            // Different item selected
        }

        oldSelection = currentSelection;
    }
});