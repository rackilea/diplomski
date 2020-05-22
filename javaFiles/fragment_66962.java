try {
    JSONObject jsonData = new JSONObject(json);
    Boolean success = jsonData.getBoolean("success");
    String message = jsonData.getString("message");

    if (success) {
    //success
    } else {
    // failed to Register Fine
    }
} catch (JSONException e) {
    e.printStackTrace();
}