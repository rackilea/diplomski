builder.execute(new ActionListner<BulkIndexByScrollResponse> {
   void onResponse(Response response) {
   // do something
   }
   void onFailure(Exception e) {
   // do something
   }
}