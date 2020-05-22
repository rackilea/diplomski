public void onResponse(JSONObject response) {

    try {
        JSONArray jsonArray = response.getJSONArray("Account");
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        account.setUname(jsonObject.optString("uname"));
     // account.setPword(jsonObject.optString("pword"));
        account.setKey(jsonObject.optInt("key"));
        account.setName(jsonObject.optString("name"));
        account.setRemarks(jsonObject.optString("remarks"));
        useAccount(account);
        requestQueue.stop();
    }
    catch (JSONException e) {
        Toast.makeText(getApplicationContext(), "Fetch failed!", Toast.LENGTH_SHORT).show();
        requestQueue.stop();
    }
}