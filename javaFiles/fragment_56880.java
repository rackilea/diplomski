SELECT ?c 
WHERE { 
     { ?c a rdfs:Class } 
     UNION 
     { [] rdf:type ?c }
     UNION
     { [] rdfs:domain|rdfs:range ?c }
     UNION
     { ?c rdfs:subClassOf|^rdfs:subClassOf [] }         
}