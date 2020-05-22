String sparqlQueryString1= "select distinct ?book ?prop ?obj " +
       "where { " +
       "  ?book a dbpedia-owl:Book . " +
       "  ?book ?prop ?obj . " +
       "  ?book dbpprop:isbn ?isbn . " +
       "  FILTER (regex(?isbn, \"0-553-05250-0\")) " +
       "} " +
       "LIMIT 100";

Query query = QueryFactory.create(sparqlQueryString1);
QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);

ResultSet results = qexec.execSelect();
ResultSetFormatter.out(System.out, results, query);       

qexec.close() ;