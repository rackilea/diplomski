// Fetch the JSON 

val string = preferences.getString("list", "")

// Convert it back into a List

val list: List<MyObject> = gson.fromJson(string, object : TypeToken<List<MyObject>>() {}.type)