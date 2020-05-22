SolrQuery parameters = new SolrQuery();
parameters.set("q", mQueryString);

QueryResponse response = solr.query(parameters);

SolrDocumentList list = response.getResults();