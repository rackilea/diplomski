@Override
public void onAttachedToWindow()
  {
  this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
  super.onAttachedToWindow();
  }