SELECT ?c 
WHERE { 
    { ?c rdfs:subClassOf [] }
    UNION
    { [] rdfs:subClassOf ?c }
}