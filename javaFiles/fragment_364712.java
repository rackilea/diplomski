BulkRequestBuilder br = null;
/// some looping construct
while (rs.next()) {
   if (br != null && br.numberOfActions() >= batchSize) {
     processResponse(br.execute().get());
     br = null;
   }
   if (br == null) {
     br = client.prepareBulk();
   }
   // do whatever to create IndexRequest
   br.add(ir);
}
if (br != null) {
  processResponse(br.execute().get());
}