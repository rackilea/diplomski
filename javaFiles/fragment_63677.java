JSONObject detailblog1 = new JSONObject();

    try {
        detailblog1.put("id","");
        detailblog1.put("name","");
        detailblog1.put("date",0);
        detailblog1.put("cant_post",0);
        detailblog1.put("creator",0);
        detailblog1.put("theme",0);

    } catch (JSONException e) {
        e.printStackTrace();
    }

    JSONObject detailblog2 = new JSONObject();

    try {
        detailblog2.put("id","");
        detailblog2.put("name","");
        detailblog2.put("date",0);
        detailblog2.put("cant_post",0);
        detailblog2.put("creator",0);
        detailblog2.put("theme",0);
    } catch (JSONException e) {
        e.printStackTrace();
    }


    JSONObject detailblog3 = new JSONObject();

    try {
        detailblog3.put("id","");
        detailblog3.put("name","");
        detailblog3.put("date",0);
        detailblog3.put("cant_post",0);
        detailblog3.put("creator",0);
        detailblog3.put("theme",0);
    } catch (JSONException e) {
        e.printStackTrace();
    }


    JSONArray jsonArray = new JSONArray();

    jsonArray.put(detailblog1);
    jsonArray.put(detailblog2);
    jsonArray.put(detailblog3);