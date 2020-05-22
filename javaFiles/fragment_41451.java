// Queries documents with first_name=randombee or id=SP2514N
// and shows fields id and name
query = new SolrQuery();
query.setQuery("first_name:randombee OR id:SP2514N");
query.setFields("id", "name"); // set fields you want to show

response = null;
try {
    response = solr.query(query);
} catch (SolrServerException e) {/* */ }
list = response.getResults();
System.out.println(list.toString());