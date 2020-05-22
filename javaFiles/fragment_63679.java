JSONObject json = new JSONObject();
    try {
        json.put("blogs",blogs);
    } catch (JSONException e) {
        e.printStackTrace();
    }

    Log.d("json",json.toString());