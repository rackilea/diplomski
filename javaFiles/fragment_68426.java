TupleQueryResultParser parser = QueryResultIO.createParser(TupleQueryResultFormat.SPARQL);

TupleQueryResultHandler handler = new MyCustomStreamingResultHandler();
parser.setQueryResultHandler(handler);

parser.parseQueryResult(in);