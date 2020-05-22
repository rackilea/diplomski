JSONObject feeds = objects.getJSONObject("feeds");

Iterator<String> keys = feeds.keys();
while (keys.hasNext()) {
    JSONObject row = feeds.getJSONObject(keys.next());
    feed_title = row.getString("feed_title");
    tv.setText(feed_title);
}