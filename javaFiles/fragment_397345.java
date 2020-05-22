JSONArray array = new JSONArray();
    try {
        for (int i = 0; i < model.size(); i++) {
            JSONObject object = new JSONObject();
            object.put("title", model.get(i).getTitle());
            array.put(object);
        }


        System.out.println("JSONArray: " + array.toString());

    } catch (JSONException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }