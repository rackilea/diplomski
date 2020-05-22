select distinct ?book ?prop ?obj 
where {
  ?book a dbo:Book .
  ?book ?prop ?obj .
  ?book dbp:isbn ?isbn .
  FILTER (regex(?isbn, "0-553-05250-0"))
} 
LIMIT 100