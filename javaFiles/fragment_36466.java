api.myMethod(new APIListener() {
  @Override
  public void apiResponseSuccess(Object output) {
    Log.i("output from api",(String) output);
  }

  @Override
  public void apiResponseFailed(String output) {

  }
}, "my String", true);