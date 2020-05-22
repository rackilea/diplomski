new NonStrictExpectations () {
  RsrcResolver rsrcResolver;
  RsrcSet rsrcSet;
  {
    rsrcResolver.getForQuery((Query) any, (RsrcContext)any, anyInt);
    result = rsrcSet;
    rsrcSet.doSomethingElse();
  }
}