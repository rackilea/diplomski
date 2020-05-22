JSONObject obj = new JSONObject("JSON_String");
JSONArray array = obj .getJSONArray("Suburban Station Departures: September 1, 2017, 10:18 pm");
for(int i=0;i<array .length;i++)
{
 JSONObject objDepartures = array .getJSONObject(i);
 JSONArray arrayNorthbound=objDepartures .getJSONArray("Northbound");
   for(int i=0;i<arrayNorthbound.length;i++)
   {
      JSONObject objDepartures = arrayNorthbound.getJSONObject(i);
      String direction=objDepartures .getString("direction");
      // rest same
    }
}