Handler delayedRun = new Handler();
delayedRun.post(new Runnable() {
  @Override
  public void run() {
    edit.requestFocus();
    InputMethodManager mgr = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
    mgr.showSoftInput(addressBox, InputMethodManager.SHOW_IMPLICIT);
  }
});