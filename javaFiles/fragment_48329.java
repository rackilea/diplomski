@Override
protected Dialog onCreateDialog(int id) {
    switch (id) {
    case DIALOG_REMOVE_CALC:
        return createDialogRemoveConfirm(DIALOG_REMOVE_CALC);
    case DIALOG_REMOVE_PERSON:
        return createDialogRemoveConfirm(DIALOG_REMOVE_PERSON);
    }
}