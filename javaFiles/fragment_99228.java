QueryRequest alltags = new QueryRequest("Tag");
alltags.setQueryFilter(new QueryFilter("Name", "=", tagx);
QueryResponse resp = r.query(alltags);
if(resp.wasSuccessful() && resp.getResults().size() == 1) {
    //tag is at index 0 in results
}