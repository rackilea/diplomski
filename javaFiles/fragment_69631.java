@Override
protected Void doInBackground(Void... params) {
        // Create the array 
        arraylist = new ArrayList<HashMap<String, String>>();
        // Retrive JSON Objects from the given website URL in JSONfunctions.class
        jsonobject = JSONFunctions.getJSONfromURL("http://www.shoppersgroup.net/vanmanagement/results.php");

        try {
            // Locate the array name
            jsonarray = new JSONArray(jsonobject.toString());

            for (int i = 1; i < jsonarray.length(); i++) {// strat from index1 
                HashMap<String, String> map = new HashMap<String, String>();
                JSONObject jsonobj = jsonarray.getJSONObject(i);
                //Log.i(MainActivity.class.getName(), jsonobj.getString("movie_name"));
                // Retrive JSON Objects
                map.put(TAG_CODE, jsonobj.getString("salesordercard_code"));
                map.put(TAG_LOCATION_FROM, jsonobj.getString("location_from"));
                map.put(TAG_LOCATION_TO, jsonobj.getString("location_to"));
                // Set the JSON Objects into the array
                arraylist.add(map);
            }
        } catch (JSONException e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return null;
}