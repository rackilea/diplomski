class Thing
{
  private int cbcheck;

  public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
  {
    cbcheck = isChecked ? 1 : 0;
  }

  /* ... */
}