JSONObject orderObj = database.getOrder(salesorderId);
JSONArray lineArr = orderObj.getJSONArray("order_items"); //lines
JSONObject lineObj = null;
// To here:
Map map = new HashMap();
for ( int i = 0; i < lineArr.length(); ++i )
{
  lineObj = lineArr.getJSONObject(i);
  String source_location = lineObj.getString("source_location");
  String key = source_location.concat( lineObj.has("ship_date") ?
               lineObj.getString("ship_date") : lineObj.getString("req_ship_date"));
  // From here: Map map=new HashMap();
  if ( !map.containsKey(key) )
  {
    map.put(key, map.size() + 1);
  }
  lineObj.put("number", map.get(key).toString());
}
orderObj.append("order_items", lineObj);