void testServiceCallWithNoKeyPropertyFound() {
  Component componentUnderTest = new Component() {
    Integer getProperties(String key) {
       return null; // property should not be found
    }

    Request getRequest() {
      return new Request(...); //this request should not contain a property named "key", 
    }

    Bind getBind() {
      return new Bind(...); //this bind should not contain a property named "key"
    }

    String makeServiceCall(String url) {
      if (url.endsWith("null")) {
        return success;
      }
      throw new AssertionError("expected url ending with null, but was " + url);
    }

  };
  componentUnderTest.activate();
  assertThat(componentUnderTest.getSomeString(), equalTo("success"));
}