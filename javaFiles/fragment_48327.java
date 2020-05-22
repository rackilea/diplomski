private Dialog createDialogRemoveConfirm(final int dialogRemove) {
    return new AlertDialog.Builder(getApplicationContext())
    .setIcon(R.drawable.trashbin_icon)
    .setTitle(R.string.calculation_dialog_remove_text)
    .setPositiveButton(R.string.calculation_dialog_button_ok, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int whichButton) {
            handleRemoveConfirm(dialogRemove);
        }
    })
    .setNegativeButton(R.string.calculation_dialog_button_cancel, null)
    .create();
}