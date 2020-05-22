JSONArray dj_listArray = mJsonObject.getJSONArray("dj_list");
for (int i = 0; i < dj_listArray.length(); i++) {
    CustomModel model = new CustomModel();
    JSONObject getDjsched = dj_listArray.getJSONObject(i);
    model.host_name = getDjsched.getString("host_name");
    model.host_image_url =getDjsched.getString("host_image_url");
    model.host_info_url= getDjsched.getString("host_info_url"));
    getDjname.put(i, model);
}