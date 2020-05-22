try {
        JSONObject json = new JSONObject(myResponse);

        j = json.getInt("total_results");
        JSONArray results = json.getJSONArray("results");
        for (int i=0; i<results.length(); i++) {
            JSONObject thisResult = results.getJSONObject(i);
            String thisTitle = thisResult.getString("title");
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }