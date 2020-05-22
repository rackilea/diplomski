Map<String, Object> data = message.getDataAsMap();
if(data.containsKey("list"))
{
    JSONArray ja = new JSONArray(data.get("list"));
    String idList = ja.toString();
}