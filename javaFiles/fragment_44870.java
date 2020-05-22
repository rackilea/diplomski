public String[] getInfo(String url) {  
    try {
        String result  = HttpGet(url);
        JSONObject json = new JSONObject(result);
        JSONObject val = json.getJSONObject("SearchResult");
        JSONArray data = val.getJSONArray("aircraft");
        int arrayLength = data.length();
        String[] strAryAns = new String[arrayLength]; 

        for(int i=0;i<arrayLength;i++)
        {
            JSONObject data1 = data.getJSONObject(i);
            strAryAns[i] = data1.getString("ident");
        }

    } catch (JSONException e) {
        e.printStackTrace();
    } 

    return strAryAns;
}