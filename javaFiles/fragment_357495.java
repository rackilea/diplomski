public static String getJsonString(Object obj) throws JSONException {
        Gson gson = new Gson();
        if (obj != null) {
            String json = gson.toJson(obj);
            JSONObject jsonObject = new JSONObject(json);


            return jsonObject.toString();
        } else
            return "";
    }

3.Post this data(Return by getJsonString() say dataToPost ) as per your requirement