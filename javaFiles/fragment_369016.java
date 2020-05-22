PREFIX  rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX  lexvo: <http://lexvo.org/ontology#>

SELECT  ?lexlabel
WHERE
  { <http://dbpedia.org/resource/Fernando_Alonso> lexvo:label ?lexlabel .
    <http://dbpedia.org/resource/Fernando_Alonso> rdfs:label ?label
    FILTER langMatches(lang(?label), "en")
    FILTER langMatches(lang(?lexlabel), "en")
    FILTER ( ?lexlabel != ?label )
  }