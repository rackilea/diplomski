ArrayList<String> myList = new ArrayList<String>();
JSONObject obj = new JSONObject();
JSONArray arr = new JSONArray();

obj = {"user":"[[{},{},{}],[{},{},{}]]";

// This gives me the outer JSONArray    
arr = obj.getJSONArray("user");

// This iterates through the outer JSONArray assigning each inner JSONArray
// to my ArrayList as strings.
for( int i = 0; i < arr.length(); i++){
    myList.put(arr.getJSONArray(i).toString());
}