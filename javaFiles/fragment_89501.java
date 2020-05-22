String failureMsg = "";
for (int i = 0; i < tests.length; i++) {
    try {
      // your test logic comes here
    } catch (AssertionError assertFaild) {
      // log error or signal it somehow, e.g.:
      failureMsg = failureMsg + assertFaild.getMessage();
    }
}
if (!failureMsg.isEmpty()) {
     // you might want to collect more data
     Assert.fail(failureMsg);
}