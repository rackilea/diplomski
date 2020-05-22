double latLong[] = {124.6682391, -17.8978304};
        JSONArray jsonArray = new JSONArray(latLong);
        JSONObject jobj = new JSONObject().put("type", "point");
        jobj.put("coordinates", jsonArray);

        // below  jsonObject_loc contains the jsonobject as you want..
        JSONObject jsonObject_loc = new JSONObject();
        jsonObject_loc.put("loc", jobj);
        System.out.println(jsonObject_loc);

       // but you have to store jobj in db as your query already has 'loc' object
        BasicDBObject loc = new BasicDBObject();
        loc.put("loc", jobj.toString());