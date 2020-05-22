public void getJSONArray() throws JSONException {

        JSONArray jo= new JSONArray();

        JSONObject obj1= new JSONObject();
        obj1.put("A","a");

        JSONObject obj2= new JSONObject();
        obj2.put("B","b");

        JSONObject obj3= new JSONObject();
        obj3.put("B","c");

        jo.put(obj1);
        jo.put(obj2);
        jo.put(obj3);

        System.out.println(jo.toString());

    }