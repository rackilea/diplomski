String json = ...;
JSONObject JsonObj = new JSONObject(json);
JSONArray ResultArr = JsonObj.getJSONArray("result");
JSONObject ResultObj = ResultArr.getJSONObject(0);
JSONObject Geometry = ResultObj.getJSONObject("geometry");
JSONObject Location = Geometry.getJSONObject("location");
double Latitude = Location.getDouble("lat");
double Longitude = Location.getDouble("lng");