public void onClick(View v) {
    JSONObject payLoad = new JSONObject();
    try {
        payLoad.put("first_name", f_name.getText().toString());
        payLoad.put("last_name", l_name.getText().toString());
        payLoad.put("age", age.getText().toString());

        new SendPostRequest.execute("http://123.456.789.78:8080/address1/address2", postData.toString());
    } catch (JSONException e) {
        e.printStackTrace();
    }
}