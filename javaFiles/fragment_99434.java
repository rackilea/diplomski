final String queryString =
        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
        "SELECT ?s ?label ?contains" 
        "WHERE {" +
        "   ?s rdfs:label ?label ." +
        "   BIND(CONTAINS(?label,\""+ variableToFind +"\") AS ?contains)"
        "}";