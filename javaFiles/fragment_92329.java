protected void outputTimings(JSONArray jsonArray) {
    String[] prayers = {"fajr", "shurooq", "dhuhr", "asr", "maghrib", 
"isha"};
    cityModel cityObj;
    try {
        cityObj= new cityModel();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject cityObject =
                    jsonArray.getJSONObject(i);
            // for(int z=0; z < cityObject.length(); z++) {
            cityObj.setFajr(""+cityObject.getString("fajr"))
            // do for more same as

        }
}