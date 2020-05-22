switchView.post(new Runnable() {
  public void run() {
    if (isChecked) {
                switchItem.setTitle(R.string.availability_on_shift);
            } else {
                switchItem.setTitle(R.string.availability_off_shift);
            }
  }
});