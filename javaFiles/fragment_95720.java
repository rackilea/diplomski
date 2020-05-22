private void parseJsonData(String jsonResponse){
        try
        {
            JSONArray jsonArray = new JSONArray(jsonResponse);

            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                String value1 = jsonObject1.optString("key1");
                String value2 = jsonObject1.optString("key2");
                String value3 = jsonObject1.optString("key3");
                String value4 = jsonObject1.optString("key4");
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }