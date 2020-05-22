select * where { 
  ?film a dbpedia-owl:Film 
  optional { ?film dbpprop:released        ?released    }
  optional { ?film dbpedia-owl:releaseDate ?releaseDate }
  optional { ?film dcterms:subject [ rdfs:label ?catLabel ]
             filter( regex( ?catLabel, "^[0-9]{4}.*films", "i" ) )
           }
}
order by ?film 
limit 100