String jsReturn =" [{\"type\":1, \"txt\":\"ERROR\"}]";
    JSONArray array = new JSONArray(jsReturn); 
    int i = 0;
    JSONObject myJsonObject = new JSONObject();
    while(i < array.length()){
        myJsonObject = array.getJSONObject(i); 
        System.out.println(myJsonObject.getString("txt"));
        i++;
    }