SolrQuery solrQuery = new SolrQuery();

solrQuery.set("q", query); //where query is solr query string (e.g. *:*)
solrQuery.set("start", 0);
solrQuery.set("rows", 10);

solrQuery.set("group", true);
solrQuery.set("group.field", "token_group");
solrQuery.set("group.ngroups", true);
solrQuery.set("group.limit", 20);