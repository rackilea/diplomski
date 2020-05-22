/**
 * Constructs feed items based on the JSON string.
 * 
 * @param response String containing JSON with feed items array.
 * @throws JSONException
 */
public FeedItems(String response) throws JSONException
{
    JSONObject json = new JSONObject(response);
    JSONArray items = json.getJSONArray("items");
    for (int i = 0; i < items.length(); i++)
    {
        JSONObject feedItemObject = items.getJSONObject(i);
        String id = feedItemObject.getString("id");
        String title = feedItemObject.getString("title");
        FeedItem feedItem = new FeedItem(id, title);
        feedItems.add(feedItem);
    }
}