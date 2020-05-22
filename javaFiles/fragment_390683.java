public void method1() {
    QueryStatisticObjectId("Age", new GetCallback<ParseObject>() {
        @Override
        public void done(ParseObject object, ParseException e) {
            if (e == null) {
                String objectId = object.getObjectId();
                Log.i(TAG, "objectId returned to method = " + objectId);
            } else {
                Log.i(TAG, "objectId not found");
            }               
        }
    });
}

public void QueryStatisticObjectId(final String statistic, GetCallback<ParseObject> callback) {
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Statistics");
    query.whereEqualTo("user", ParseUser.getCurrentUser());
    query.whereEqualTo("statistic", statistic);
    query.getFirstInBackground(callback);
}