String resultsString = "[{ 'id': 248, 'name': 'Alternatif Cibubur', 'slug': 'alternatif-cibubur', 'status': 'active', 'longitude': 106.900786 }]";
String cityString = "[{ 'id': 11, 'name': 'Depok', 'slug': 'depok' }]";

try
{
    //Convert String into JSONArray for both results and city.
    JSONArray resultsJArray = new JSONArray(resultsString);
    JSONArray cityJArray = new JSONArray(cityString);

    //Get the first and only JSONObject within each of the arrays.
    JSONObject resultsJObject = resultsJArray.getJSONObject(0);
    JSONObject cityJObject = cityJArray.getJSONObject(0);

    //Get the required values from the JSONObject within city.
    int city_id = cityJObject.getInt("id");
    String city_name = cityJObject.getString("name");
    String city_slug = cityJObject.getString("slug");

    //Put the values into the results JSONObject.
    resultsJObject.put("city_id", city_id);
    resultsJObject.put("city_name", city_name);
    resultsJObject.put("city_slug", city_slug);

    //Print to verify.
    System.out.println("Updated resultsJArray: " + resultsJArray);
}
catch (JSONException e)
{
    e.printStackTrace();
}