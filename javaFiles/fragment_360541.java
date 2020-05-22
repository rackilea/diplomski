========================
@prefix ex:    <http://example.org/demo#> .
@prefix rdf:   <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .
@prefix rdfs:  <http://www.w3.org/2000/01/rdf-schema#> .
@prefix sp:    <http://spinrdf.org/sp#> .

_:b0    a              sp:Filter ;
        sp:expression  [ a        sp:gt ;
                         sp:arg1  [ sp:varName  "age" ] ;
                         sp:arg2  18
                       ] .

_:b1    sp:object     [ sp:varName  "age" ] ;
        sp:predicate  ex:age ;
        sp:subject    [ sp:varName  "person" ] .

[ a                   sp:Select ;
  rdfs:comment        "Comment1" ;
  sp:resultVariables  ( _:b2 ) ;
  sp:where            ( _:b3 _:b1 _:b0 )
] .

_:b3    sp:object     ex:Person ;
        sp:predicate  rdf:type ;
        sp:subject    [ sp:varName  "person" ] .

_:b2    sp:varName  "person" .

[ a        sp:Select ;
  sp:text  "# Comment2\nSELECT ?person\nWHERE {\n    ?person a ex:Person .\n    ?person ex:age ?age .\n    FILTER (?age < 22) .\n}"
] .
========================
Select1:
# Comment1
SELECT ?person
WHERE {
    ?person a ex:Person .
    ?person ex:age ?age .
    FILTER sp:gt(?age, 18) .
}
Select2:
# Comment2
SELECT ?person
WHERE {
    ?person a ex:Person .
    ?person ex:age ?age .
    FILTER (?age < 22) .
}