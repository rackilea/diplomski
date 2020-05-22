Handler delayedRun = new Handler();
delayedRun.post(new Runnable() {
  @Override
  public void run() {
    youreditText.requestFocus();
    InputMethodManager mgr = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
    mgr.showSoftInput(youreditText, InputMethodManager.SHOW_IMPLICIT);
  }
});