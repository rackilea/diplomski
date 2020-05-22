protected void removeSplashScreen() {
    if (mSplashDialog != null) {
        mSplashDialog.dismiss();
        mSplashDialog = null;
        showDialog(NAG_BOX);
    }
}