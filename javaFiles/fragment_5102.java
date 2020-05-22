public static List<App> getAppList(JSONArray array){
    List<App> appList = new ArrayList<>();
    for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            appList.add(buildAppInfo(object.getString("category"), object.getString("title"), object.getString("description"), object.getString("developer"), object.getString("packageName"), object.getString("iconImageUrl"), object.getString("bgImageUrl")));
    }
    return appList;
}