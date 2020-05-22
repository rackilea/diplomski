public static void main(String[] args) {
    String json = "{ \"data\": { \"current_condition\": [ {\"cloudcover\": \"75\", \"humidity\": \"71\", \"observation_time\": \"06:55 AM\", \"precipMM\": \"0.6\", \"pressure\": \"1009\", \"temp_C\": \"32\", \"temp_F\": \"90\", \"visibility\": \"10\", \"weatherCode\": \"116\", \"weatherDesc\": [ {\"value\": \"Partly Cloudy\" } ], \"weatherIconUrl\": [ {\"value\": \"http:\\/\\/cdn.worldweatheronline.net\\/images\\/wsymbols01_png_64\\/wsymbol_0002_su‌​nny_intervals.png\" } ], \"winddir16Point\": \"S\", \"winddirDegree\": \"170\", \"windspeedKmph\": \"9\", \"windspeedMiles\": \"6\" } ]}}";
    try {
        JSONObject jObj = new JSONObject(json);
        JSONObject dataResult = jObj.getJSONObject("data");
        JSONArray jArr = (JSONArray) dataResult.getJSONArray("current_condition");
        for(int i = 0; i < jArr.length();i++) {
            JSONObject innerObj = jArr.getJSONObject(i);
            for(Iterator it = innerObj.keys(); it.hasNext(); ) {
                String key = (String)it.next();
                System.out.println(key + ":" + innerObj.get(key));
            }
        }
    }
    catch (JSONException e) {
        e.printStackTrace();
    }

}