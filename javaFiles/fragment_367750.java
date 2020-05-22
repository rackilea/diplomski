SearchResponse response = client.prepareSearch("mongoindex")
    .setSearchType(SearchType.QUERY_AND_FETCH)
    .setQuery(fieldQuery("name", "test name"))
    .setFrom(0).setSize(60).setExplain(true)
    .execute()
    .actionGet();
SearchHit[] results = response.getHits().getHits();
for (SearchHit hit : results) {
  System.out.println(hit.getId());    //prints out the id of the document
  Map<String,Object> result = hit.getSource();   //the retrieved document
}