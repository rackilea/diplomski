@Override
public void onResume() {
    super.onResume();
    theView.requestFocus();
    theView.requestFocusFromTouch();
}