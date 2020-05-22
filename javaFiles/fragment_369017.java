SELECT ?lexlabel WHERE 
{
GRAPH ?g {<http://dbpedia.org/resource/Fernando_Alonso> lexvo:label ?lexlabel . }
<http://dbpedia.org/resource/Fernando_Alonso> rdfs:label ?label .  
FILTER (LANGMATCHES(LANG(?label), "en"))
FILTER (LANGMATCHES(LANG(?lexlabel), "en"))
FILTER (?lexlabel != ?label) .  }