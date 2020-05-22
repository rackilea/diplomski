SELECT ?movie (count(?mTitle) as ?nTitles)
WHERE {
  ?movie a dbpedia-owl:Film ;
         rdfs:label ?mTitle .
  filter langMatches(lang(?mTitle),'en')
}
group by ?movie
having count(?mTitle) > 1