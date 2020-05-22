public static void main(String[] args) throws SolrServerException, IOException {
    String url = "http://192.168.0.10:8983/solr";

    SolrClient client = new HttpSolrClient.Builder(url).build();
    SolrQuery query = new SolrQuery();
    query.setQuery("*:*");
    query.addFilterQuery("user:\"krystina.morissette\"");
    query.setRows(10);
    QueryResponse response = client.query("gatling.user_tokens", query);
    SolrDocumentList list = response.getResults();
    System.out.println("Num found=" + list.getNumFound());
    for (SolrDocument doc: list) {
        System.out.println(doc);
    }
}