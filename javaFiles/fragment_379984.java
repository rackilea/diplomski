String strJson= "{\"Location\" :[{\"name\":\"Gladiator Fitness\",\"latlng\":[\"53.2286362\",\"-0.5856869\"],\"country\":\"GB\"}]}\n";

    try {
        JSONObject jsonRootObject = new JSONObject(strJson);
        JSONArray jsonArray = jsonRootObject.optJSONArray("Location");

        //Iterate the jsonArray and print the info of JSONObjects
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            //Search the database for the "data"
            String name = jsonObject.optString("name").toString();
            String country = jsonObject.optString("country").toString();
            JSONArray latlng = jsonObject.optJSONArray("latlng");
            double lat = latlng.optDouble(0);
            double lng = latlng.optDouble(1);

            Log.d("JSON", "coords: " + lat + " " + lng);
        }
    } catch (Exception e) {
        Log.d("JSON", "e: " + e);
    }