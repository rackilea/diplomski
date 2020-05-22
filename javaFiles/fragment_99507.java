String solrDir = "C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/solr/new_core/";

//this solr Directory is home and specified core.

//solrParams.set("qt", "/dataimport");
//solrParams.set("command", "full-import");

//above two line for importing data one time.

CoreContainer container = new CoreContainer(solrDir);
container.load();
EmbeddedSolrServer server = new EmbeddedSolrServer(container, "collection1");

ModifiableSolrParams solrParams = new ModifiableSolrParams();
solrParams.add(CommonParams.Q, "*:*");

QueryResponse queryResponse = server.query(solrParams);
for (SolrDocument document : queryResponse.getResults()) {
  System.out.println(document);
}