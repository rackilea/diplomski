String str = "{\"tag\":\"Login\",\"tdata\":[{\"ID\":[[\"C1\",\"C2\"]],\"Name\":[[\"ABC\",\"PQR\"]]}]}";
    System.out.println(str);
    JSONObject all;
    try {
        all = new JSONObject(str);
        JSONArray data =  all.getJSONArray("tdata");              //data = [{"ID":[["C1","C2"]],"Name":[["ABC","PQR"]]}]
        JSONObject insideData=data.getJSONObject(0);              // insideData = {"ID":[["C1","C2"]],"Name":[["ABC","PQR"]]}
        JSONArray C1C2OutterArray=insideData.getJSONArray("ID");  // C1C2OutterArray = [["C1","C2"]]
        JSONArray C1C2InnerArray=C1C2OutterArray.getJSONArray(0); // C1C2InnerArray = ["C1","C2"]   
        String C1 = C1C2InnerArray.getString(0);                  // C1 = C1
        String C2 = C1C2InnerArray.getString(1);                  // C2 = C2

        JSONArray nameOutterArray=insideData.getJSONArray("Name");// nameOutterArray = [["ABC","PQR"]]
        JSONArray nameInnerArray=nameOutterArray.getJSONArray(0); // nameInnerArray = ["ABC","PQR"] 
        String ABC = nameInnerArray.getString(0);                 // ABC = ABC
        String PQR = nameInnerArray.getString(1);                 // PQR = PQR

    } catch (JSONException e) {  

        e.printStackTrace();
    }