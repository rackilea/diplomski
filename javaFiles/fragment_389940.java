HashMap<String, Object> params = new HashMap<String, Object>();
ParseCloud.callFunctionInBackground("formerFriends", params, new FunctionCallback<Float>() {
  void done(Object result, ParseException e) {
    if (e == null) {
      // success
    }
  }
});