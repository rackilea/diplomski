public String getList() throws JSONException {

    User dataUser  =memberO.getMember(1);
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("name", dataUser.getUserName());
    jsonObject.put("account", dataUser.getAccount());
    jsonObject.put("edit", dataUser.getUserId());
    jsonObject.put("delete", dataUser.getUserId());

    JSONArray jsonArray = new JSONArray();
    jsonArray.add(jsonObject);


    JSONObject responseJson = new JSONObject();
    responseJson.put("data", jsonArray);//Here you can see the data in json format

    return responseJson.toString();


}