@Override
public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);

    if (!hasFocus) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
    } else {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
    }
}