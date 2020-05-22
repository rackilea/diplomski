public HashMap<String, Integer> convertToHashMap(String jsonString) {
        HashMap<String, Integer> myHashMap = new HashMap<String, Integer>();
        try {
            JSONArray jArray = new JSONArray(jsonString);
            JSONObject jObject = null;
            String keyString=null;
            for (int i = 0; i < jArray.length(); i++) {
                jObject = jArray.getJSONObject(i);
                // beacuse you have only one key-value pair in each object so I have used index 0 
                keyString = (String)jObject.names().get(0);
                myHashMap.put(keyString, jObject.getInt(keyString));
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return myHashMap;
    }