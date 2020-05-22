public  Map<String, HashMap<String, String>> map = new HashMap<String, HashMap<String, String>>();


JSONArray JA = new JSONArray(this.jsonData);
    int i = 0;
    while (i < JA.length()) {
        JSONObject JO = (JSONObject) JA.get(i);
        Map<String, String> innerMap = new HashMap<String, String>();
        innerMap.put("mobile", JO.get("mobile").toString());
        innerMap.put("msg", JO.get("msg").toString());
        innerMap.put("company", JO.get("company").toString());
        innerMap.put("name", JO.get("name").toString());

        map.put(JO.get("id").toString(), innerMap);
    }