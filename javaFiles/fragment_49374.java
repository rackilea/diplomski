String jsonString = "Paste server response in json";

        try {
            JSONObject jsonObject = new JSONObject(jsonString);

            JSONObject dataJson = jsonObject.getJSONObject("data");
            String address = dataJson.optString("address","Not Available");

        } catch (JSONException e) {
            e.printStackTrace();
        }