interface ParseCallback {
    void onComplete(String result);
    //todo onError() ?
}

protected void parse(ParseCallback callback) {
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Topics");
    query.getInBackground("fRGt3oz8af", new GetCallback<ParseObject>() {
        public void done(ParseObject arg0, ParseException arg1) {
            if (arg1 == null) {
                String subTopicName = arg0.getString("class_1");
                if (subTopicName != null) {
                    callback.onComplete(subTopicName);
                }
            } else {
                Log.d("topic", "Error: " + arg1.getMessage());
            }
        }
    });
}

public void example() {
    parse(result -> {
        runOnUiThread(() -> {
            myTextView.setText(result);
        });
    });
}