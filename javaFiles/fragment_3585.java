ParseQuery<ParseObject> query = ParseQuery.getQuery("GameScore");
query.whereEqualTo("playerEmail", "dstemkoski@example.com");
query.getFirstInBackground(new GetCallback<ParseObject>() {
  public void done(ParseObject object, ParseException e) {
    if (object == null) {
      Log.d("score", "The getFirst request failed.");
    } else {
      Log.d("score", "Retrieved the object.");
    }
  }
});