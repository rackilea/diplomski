JSONObject jsonObject = (JSONObject) obj;
    JSONArray result = (JSONArray) jsonObject.get("rows");
    for (int i = 0; i < result.size(); i++) {
        JSONObject jsonObject1 = (JSONObject) result.get(i);
        JSONArray jsonarray1 = (JSONArray) jsonObject1.get("media");
        for (int j = 0; j < jsonarray1.size(); j++) {
            System.out.println(((JSONObject) jsonarray1.get(j)).get(
                    "height").toString());
            System.out.println(((JSONObject) jsonarray1.get(j)).get(
            "width").toString());
            System.out.println(((JSONObject) jsonarray1.get(j)).get(
            "filename").toString());
        }

    }