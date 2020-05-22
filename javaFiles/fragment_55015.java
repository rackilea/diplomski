String str = "....";
ParsedOperation operation =  QueryParserUtil.parseOperation(QueryLanguage.SPARQL, str, null);
if (operation instanceof ParsedQuery) {
   // it's a query
} else {
   // it's an update
}