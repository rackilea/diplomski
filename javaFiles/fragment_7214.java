// save the last good (i.e. validated) selection:
private ProjectClass lastSelectedProj;

// listing of available projects:
private JList list;

// true if current selected project has been modified without saving:
private boolean dirty;

list.addListSelectionListener(new ListSelectionListener() {
    public void valueChanged(ListSelectionEvent evt) {

    if (evt.getValueIsAdjusting()) return;

    // first validate this selection, and give the user a chance to cancel.
    // e.g. if selected project is dirty show save: yes/no/cancel dialog.
    if (dirty) {
        int choice = JOptionPane.showConfirmDialog(this,
            "Save changes?",
            "Unsaved changes",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.WARNING_MESSAGE);

        // if the user cancels the selection event revert to previous selection:
        if (choice == JOptionPane.CANCEL_OPTION) {
            dirty = false; // don't cause yet another prompt when reverting selection
            list.setSelectedValue(lastSelectedProj, true);
            dirty = true;  // restore dirty state. not elegant, but it works.
            return;
        } else {
            // handle YES and NO options
            dirty = false;
        }
    }

    // on a validated selection event:
    lastSelectedProj = list.getSelectedValue();

    // proceed to update views for the newly selected project...
}
}