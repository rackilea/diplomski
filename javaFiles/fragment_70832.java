public static void main(String[] args) throws JSONException {

    JSONObject obj = null;

    JSONArray cellArray = new JSONArray();
    JSONArray cellArray1 = new JSONArray();

    for (int i = 0; i < 2; i++) {
        obj = new JSONObject();

        obj.put("id", i);
        obj.put("cell", "contecnt 1, content 2, content 3");

        cellArray.put(obj);
    }

    JSONObject responseData = new org.json.JSONObject();

    responseData.put("rows", cellArray);

//      System.out.println(responseData);

    JSONObject obj1 = new JSONObject();

    obj1.put("stat", "ok");
    obj1.put("total", "100");
    obj1.put("page", 1);
    obj1.put("rows", responseData);

    cellArray1.put(obj1);

    JSONObject response = new org.json.JSONObject();

    response.put("data", cellArray1);

    System.out.println(response);
}