if(mIntent.getStringExtra("jsonString") != null) {
    Log.d("json", mIntent.getStringExtra("jsonString"));

    try {
        JSONObject object = new JSONObject(mIntent.getStringExtra("jsonString"));

        JSONArray array = object.getJSONObject("document").getJSONObject("businessCard").getJSONArray("field");

        for (int i = 0; i < array.length(); i++) {
            JSONObject subObject = array.getJSONObject(i);

            String type = subObject.getString("type");
            String value = subObject.getString("value");
            if (type.equals("Name")) {
                    String prevValue = edt_FirstName.getText();
                    edt_FirstName.setText((TextUtils.isEmpty(prevValue) ? "" : prevValue + ",") + value);
            }
        }

    } catch (JSONException e) { }
}