@Override
protected void onPause() {
    if (myDialog != null) {
        myDialog.dismiss();
    }
    super.onPause();
}