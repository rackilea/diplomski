JSONArray jsonArr = (JSONArray) new JSONParser().parse(jsonRequestdata);

    for(int i=0;i<jsonArr.size();i++){
            JSONObject json=(JSONObject) jsonArr.get(i);   
            System.out.println("name=" + json.get("name"));
            System.out.println("value=" + json.get("value"));
    }