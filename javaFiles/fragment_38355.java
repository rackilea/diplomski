if (response.getInt("success") == 1) {
    JSONArray sucessdetails = response.getJSONArray("data");     

    for (int i = 0; i < sucessdetails.length(); i++)  {
        JSONObject successObject = sucessdetails.getJSONObject(i);

        Log.e("Value","Of success"+successObject);
    }
} else {
    Log.e("Status", "Failed");
}