String json = ...;
JSONObject JsonObj = new JSONObject(json);
JSONArray ResultArr = JsonObj.getJSONArray("result");
int count = ResultArr.length();
for (int i = 0; i < count; ++i)
{
    JSONObject ResultObj = ResultArr.getJSONObject(i);
    JSONObject Geometry = ResultObj.getJSONObject("geometry");
    JSONObject Location = Geometry.getJSONObject("location");
    double Latitude = Location.getDouble("lat");
    double Longitude = Location.getDouble("lng");
    //...
}