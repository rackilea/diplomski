JSONObject jsonObject;
        try {            
            jsonObject = new JSONObject(jsonString1);
            JSONArray jsonArray = new JSONArray(jsonObject.get("records").toString());            
            JSONObject jsonObject1 = jsonArray.getJSONObject(0);
            jsonObject1.remove("attributes");
            jsonObject.put("records", jsonObject1);
        } catch (JSONException e) {
            e.printStackTrace();
        }