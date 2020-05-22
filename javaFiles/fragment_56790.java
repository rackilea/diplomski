qry = "PREFIX : <http://www.example.com/tempsensor#>\n" + 
      "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
      "INSERT DATA\n" +
      "{\n" + 
      ":ind1 :locatedIn :Delhi ;\n" + 
      ":onDate \"2014-10-01T00:10:10\"^^xsd:dateTime ;\n" + 
      ":measures 13 ;" + " :hasUnit Celsius .\n" + 
      "}" ;