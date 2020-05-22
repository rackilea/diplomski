// ...
AuthCallback cb = new AuthCallback() {
  @Override
  public void onAuthResult(String token) {
    // do something in the view/fragment/activity
  }
}

// then pass it as argument