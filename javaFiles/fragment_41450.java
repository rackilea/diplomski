// Queries all documents (*:*) and shows only the id
SolrQuery query = new SolrQuery();
query.setQuery("*:*"); // actual query
QueryResponse response = null;
try {
    response = solr.query(query);
} catch (SolrServerException e) {/* */ }
SolrDocumentList list = response.getResults();
System.out.println(list.toString()); // print the results of the query