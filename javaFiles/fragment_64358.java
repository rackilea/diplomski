select ?subject (count(?property) as ?numProperties) where {
  values ?property {
    dbpedia-owl:country dbpedia-owl:elevation
    dbpedia-owl:leader dbpprop:area dbpprop:flag
    dbpprop:name
  }
  ?subject ?property ?object 
}
group by ?subject 
order by desc(?numProperties)
limit 10