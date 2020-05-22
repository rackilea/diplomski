:Platforms a owl:Class ;
           owl:oneOf ( :PC :PlayStation :Xbox :Nintendo ) .

:Platform a owl:Class ;
          rdfs:label "Platform";
          rdfs:subClassOf [ a owl:Restriction ;
                            owl:onProperty :platformType ;
                            owl:someValuesFrom :Platforms ] .