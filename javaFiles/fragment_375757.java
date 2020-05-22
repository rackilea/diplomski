JSONObject search = (JSONObject) jsonObject.get("search");//1
    JSONArray entry = (JSONArray) search.get("entry");//2
    for (int i = 0; i < entry.size(); i++) {
        JSONObject jsonObject1 = (JSONObject) entry.get(i);//3
        JSONArray jsonarray1 = (JSONArray) jsonObject1.get("attribute");//4
        for (int j = 0; j < jsonarray1.size(); j++) {
            System.out.println(((JSONObject) jsonarray1.get(j)).get(
                    "value").toString());//5

        }

    }