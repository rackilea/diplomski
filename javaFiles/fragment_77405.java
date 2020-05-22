MATCH
  (enum:Enum:Type) 
WHERE NOT
  (enum)-[:DECLARES]->(:Method {static:true, name:"findByAttribute"})
RETURN
  enum.fqn