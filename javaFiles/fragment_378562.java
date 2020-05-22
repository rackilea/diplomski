// assume data is a JSONObject pointing to the loaded json data (via loadJSONObject / JSONObject.parse(), etc.

// access the info object
JSONObject info = data.getJSONObject("info");
// access the images array object
JSONArray images = data.getJSONArray("images");
// access a string inside an object
println(info.getString("description"));
// access a JSON object inside a JSON array
JSONObject firstImage = images.getJSONObject(0);

// acess an integer
println(firstImage.getInt("id"));
// ... and a string again
println(firstImage.getString("flickr_url"));