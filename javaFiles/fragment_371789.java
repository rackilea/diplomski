private class TweetJsonListener implements Listener<JSONArray> {

    @Override
    public void onResponse(JSONArray response) {
        JSONObject jsonObject = null;
        JSONArray tweets = response.optJSONArray("statuses");
        int count = tweets != null ? tweets.length() : 0;
        for (int i = 0; i < count; i++) {
            jsonObject = tweets.optJSONObject(i);
        if (jsonObject != null) {
            tweetAdapter.add(jsonObject);
        }

        activity.setProgressBarIndeterminateVisibility(false);

    }
}