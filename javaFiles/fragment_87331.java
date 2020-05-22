@Override
  public void onClick(View v) {
    // anything you want
     Intent intent = new Intent();
     intent.putExtra("isLoggedIn", myMethodToGetInfoIsLoggedIn);
     setResult(RESULT_OK, intent);
     finish();
  }