final RsrcSet queryResult = new RsrcSet();
// (insert initialization of queryResult here)

new NonStrictExpectations () {
  RsrcResolver rsrcResolver;
  {
    rsrcResolver.getForQuery((Query) any, (RsrcContext)any, anyInt);
    result = queryResult
  }
}