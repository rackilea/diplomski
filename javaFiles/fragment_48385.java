ParseQuery<ParseObject> query = ParseQuery.getQuery("MyClass");
 query.findInBackground(new FindCallback<ParseObject>() {
     public void done(List<ParseObject> objects, ParseException e) {
         if (e == null) {
             Collections.shuffle(objects);
             objectsWereRetrievedSuccessfully(objects);
         } else {
             objectRetrievalFailed();
         }
     }
 }