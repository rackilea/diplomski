SELECT DISTINCT ?movie (str(?movie_year) as ?year) (str(?movie_title) as ?title)
WHERE {
  ?movie rdf:type dbpedia-owl:Film.
  ?movie rdfs:label ?movie_title.
  FILTER langMatches(lang(?movie_title), 'en')
  optional { ?movie dbpprop:released   ?rel_year }
  optional { ?movie dbpedia-owl:releaseDate ?owl_year}
  optional { ?movie dcterms:subject ?sub.
             ?sub rdfs:label ?movie_year_sub
             filter regex(?movie_year_sub, ".*[0-9]{4}.*", "i")
           }
  BIND(COALESCE(?owl_year, ?rel_year, ?movie_year_sub) AS ?movie_year)
}
limit 2000