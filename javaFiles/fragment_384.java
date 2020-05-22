@Override
public void onResponse(JSONObject response) {
    try
    {
        JSONArray jsonArray = response.getJSONArray("latitude");
        //Loop through array
        for (int i = 0; i<jsonArray.length(); i++)
        {
            String latitude = jsonArray.getString(i);
        }
    }
    // Rest of your code can stay the same
}