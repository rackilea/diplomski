new ServletModule() {
  @Override
  protected void configureServlets() {
    filter("^/rest/.*(?<!/\\d/foo)$").through(ObjectifyFilter.class);
    filter("^/rest/.*(?<!/\\d/foo)$").through(SomeOtherFilter.class);
  }
}