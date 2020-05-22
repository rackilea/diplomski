JSONObject custom_fields = post.getJSONObject("custom_fields");
JSONArray event_start_date_array = custom_fields.getJSONArray("event_start_date");
JSONArray event_location_array = custom_fields.getJSONArray("event_location");

String event_start_date = event_start_date_array.getString(0);
String event_location = event_location_array.getString(0);