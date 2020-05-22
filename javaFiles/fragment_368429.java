protected void changeTheme(boolean dark) {
  if (dark) {
    setTheme(R.style.AppTheme);
  } else {
    setTheme(R.style.AppLightTheme);
  }
  recreate();
}