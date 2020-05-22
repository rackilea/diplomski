String retur = JSONArray.toJSONString(ret);
        JSONObject myJsonObject = new JSONObject();

        JSONArray array = new JSONArray(retur); 

        int i = 0;

        while(i < array .length()){
            myJsonObject = array .getJSONObject(i);
            System.out.println(myJsonObject.getString("txt"));
            i++;
        }