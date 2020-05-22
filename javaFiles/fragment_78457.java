// Use class Query to assemble a query
Query q = new Query("Post");

// Use PreparedQuery interface to retrieve results
PreparedQuery pq = datastore.prepare(q);


for (Entity result : pq.asIterable()) {
  String postName = (String) result.getProperty("PostName");
}