JSONObject jSONObject = new JSONObject(jsonString);
String str_type=jSONObject.getString("type");

// using JSONArray
JSONArray featuresArr = jSONObject.getJSONArray("features");
  for (int i=0; i<featuresArr.length; i++){
    JSONObject anotherjsonObject = featuresArr.getJSONObject(i);
    //access the fields of that json object
    String str_type_one=anotherjsonObject.getString("type");
   JSONArray featuresArr_properties = anotherjsonObject.getJSONArray("properties");

   JSONObject propertiesjsonObject = featuresArr_properties.getJSONObject(0);
   String str_type=propertiesjsonObject.getString("type");
   String str_type=propertiesjsonObject.getString("thumb");
   String str_type=propertiesjsonObject.getString("name_pl");
   String str_type=propertiesjsonObject.getString("name_en");
 ////parse all items ...........
  }