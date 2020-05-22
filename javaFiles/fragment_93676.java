QueryExecution qexec = QueryExecutionFactory.sparqlService(sparqlEndpointQuery, query);
ResultSet results = qexec.execSelect();

// write to a ByteArrayOutputStream
ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

ResultSetFormatter.outputAsJSON(outputStream, results);

// and turn that into a String
String json = new String(outputStream.toByteArray());

System.out.println(json);