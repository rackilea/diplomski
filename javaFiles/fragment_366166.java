match
  (:Stateless)-[:DECLARES]->(m:Method)
where
  m.visibility ="public"
  and not (
    (m)-[:ANNOTATED_BY]->()-[:OF_TYPE]->(:Type{fqn:"...PermitAll")
    or
    ... 
  )
return
  m