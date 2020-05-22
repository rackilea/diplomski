JSONObject jsonObj = new JSONObject(json);

        JSONObject lists= jsonObj.getJSONObject("list");
        Iterator x = lists.keys();
        JSONArray jsonArray = new JSONArray();

        while (x.hasNext()){
            String key = (String) x.next();
            jsonArray.put(lists.get(key));
        }