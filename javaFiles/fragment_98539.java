private void dialogProgressHide() {
    if (mDialog != null && mDialog.isShowing())
    {
        mDialog.dismiss();
        mDialog = null;
    }
}