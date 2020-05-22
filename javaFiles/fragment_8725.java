ParseQuery<ParseObject> query = ParseQuery.getQuery("YOUR_CLASS_NAME");
query.orderByDescending("gameTime");
query.setLimit(3);
 query.findInBackground(new FindCallback<ParseObject>() {
   public void done(List<ParseObject> list, ParseException e) {
     if (e == null) {
        // list object will contain only 3 objects. 
     } else {
       //objectRetrievalFailed();
     }
   }
 });