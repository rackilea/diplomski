class MyParser : MultiFieldQueryParser {
  @override
  public Query getFieldQuery(string field, string queryText) {
     if lookupSuccessful(field, queryText) { 
       return myQuery(field, queryText);
     }
     return base.getFieldQuery(field, queryText);
  }
}