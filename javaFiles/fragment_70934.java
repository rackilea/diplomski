MessageDialog dialog =
     new MessageDialog(null, "Dangerous Activity", null,
                "Are you sure you want to delete?", MessageDialog.CONFIRM,
                new String[]{"Preview>", "Delete", "Cancel"}, 0)
{
protected void buttonPressed(int buttonId) {
    setReturnCode(buttonId);
    // close(); Call close for Delete or Cancel?
}};