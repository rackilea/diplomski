/* instead of calling the dialog's onCreateDialog(), call this */
public void showNoticeDialog() {
    // Create an instance of the dialog fragment and show it
    DialogFragment dialog = new FireTheDialogFragment();

    /* use getFragmentManager() instead if not using Android support library */
    dialog.show(getSupportFragmentManager(), "DialogFragment");
}