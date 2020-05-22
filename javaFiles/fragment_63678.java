JSONObject blogs= new JSONObject();

    try {

        blogs.put("blog",blog);
        blogs.put("detailblog",jsonArray);

    } catch (JSONException e) {
        e.printStackTrace();
    }