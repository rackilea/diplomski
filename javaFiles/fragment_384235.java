JSONArray mainArray = new JSONArray(json);
for (int i = 0 ; i < mainArray.length() ; i ++)
{
    JSONObject currentItem = array.getJSONObject(i);
    String title = currentItem.getString("title");
    String body = currentItem.getString("body ");
    ....
    JSONArray currentItemStepsArray = currentItem.getJSONArray("steps"); 
    for (int j = 0 ; j < currentItemStepsArray.length() ; j ++)
    {
        ....
    }
}