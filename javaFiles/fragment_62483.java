for (int i = 0; i < data.size(); i++)
{
    JSONObject obj = (JSONObject) data.get(i);
    String text = obj.get("text");
    //...
}