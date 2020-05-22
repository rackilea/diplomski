try {
           JsonObject jsonObject = new JSONObject(json);

           JsonArray users = jsonObject.getJSONArray(JSON_ARRAY);

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                String name = jo.getString(KEY_NAME);
                String message = jo.getString(KEY_EMAIL);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }