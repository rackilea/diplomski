//I assume that we need to create a JSONArray object from the following string
    String jsonArrStr = "[ { \"ID\": \"135\", \"Name\": \"Fargo Chan\" },{ \"ID\": \"432\", \"Name\": \"Aaron Luke\" },{ \"ID\": \"252\", \"Name\": \"Dilip Singh\" }]";

    JSONArray jsonArr = new JSONArray(jsonArrStr);
    JSONArray sortedJsonArray = new JSONArray();

    List<JSONObject> jsonValues = new ArrayList<JSONObject>();
    for (int i = 0; i < jsonArr.length(); i++) {
        jsonValues.add(jsonArr.getJSONObject(i));
    }
    Collections.sort( jsonValues, new Comparator<JSONObject>() {
        //You can change "Name" with "ID" if you want to sort by ID
        private static final String KEY_NAME = "Name";

        @Override
        public int compare(JSONObject a, JSONObject b) {
            String valA = new String();
            String valB = new String();

            try {
                valA = (String) a.get(KEY_NAME);
                valB = (String) b.get(KEY_NAME);
            } 
            catch (JSONException e) {
                //do something
            }

            return valA.compareTo(valB);
            //if you want to change the sort order, simply use the following:
            //return -valA.compareTo(valB);
        }
    });

    for (int i = 0; i < jsonArr.length(); i++) {
        sortedJsonArray.put(jsonValues.get(i));
    }