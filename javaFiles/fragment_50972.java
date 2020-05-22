final QuerySolution[] solutionsAsArray;
try(final QueryExecution exec = QueryExecutionFactory.create(query, model)) {
  final Iterable<QuerySolution> execAsIterable = exec::execSelect;
  solutionsAsArray = StreamSupport
      .stream(execAsIterable.spliterator(), false)
      .toArray(count -> new QuerySolution[count]);
}