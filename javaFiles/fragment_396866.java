private void DisposeDialogWithid(String id) {
    if(openedDialogs.containsKey(id)){
        JDialog _dialog = openedDialogs.remove(id);
        // close the dialog
    }
}