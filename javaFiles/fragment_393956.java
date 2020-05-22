public void change(Context context) {
    mDialog = new ProgressDialog(context);
    mDialog.setMessage("Testing");
    mDialog.setCancelable(true);
    mDialog.show();
}