@Override
protected void describeMismatchSafely(JsonElement expectedJson, 
                                      Description mismatchDescription) {

  mismatchDescription.appendValue(expectedJson).appendText("\ndifference:\n");

  try {
     assertEquals(expectedJson.toString(), originalJson.toString());
  }
  catch (ComparisonFailure e) {
     String message = e.getMessage();
     message = message.replace("expected:", "");
     message = message.replace("but was:", "");
     message = message.replaceFirst(">", ">\n");
     mismatchDescription.appendText(message);
  }
}