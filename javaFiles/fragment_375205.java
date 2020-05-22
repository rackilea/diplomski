SELECT  ?pl ?pl_label 
        (MIN(?_abstract) AS ?abstract) # <- used MIN here to ensure stable result
        ?_thumbnail 
        (GROUP_CONCAT(DISTINCT ?_influenced_label ; separator='; ') AS ?influenced) 
        (GROUP_CONCAT(DISTINCT ?_influencedBy_label ; separator='; ') AS ?influencedBy) 
        (GROUP_CONCAT(DISTINCT ?_sameAs ; separator=', ') AS ?sameAs) 
        (GROUP_CONCAT(DISTINCT ?_paradigm_label ; separator=', ') AS ?paradigm)
WHERE
  { ?pl  a  dbo:ProgrammingLanguage ;
         rdfs:label  ?pl_label
    FILTER ( lang(?pl_label) = "en" )

    OPTIONAL
      { ?pl  dbo:abstract  ?_abstract
        FILTER ( lang(?_abstract) = "en" )
      }
    OPTIONAL
      { ?pl       dbo:influenced/rdfs:label  ?_influenced_label
        FILTER ( lang(?_influenced_label) = "en" )
      }
    OPTIONAL
      { ?pl       dbo:influencedBy/rdfs:label  ?_influencedBy_label
        FILTER ( lang(?_influencedBy_label) = "en" )
      }
    OPTIONAL
      { ?pl  owl:sameAs  ?_sameAs }
    OPTIONAL
      { ?pl       dbp:paradigm/rdfs:label  ?_paradigm_label
        FILTER ( lang(?_paradigm_label) = "en" )
      }
    OPTIONAL
      { ?pl  dbo:thumbnail  ?_thumbnail }
  }
GROUP BY ?pl ?pl_label ?_thumbnail