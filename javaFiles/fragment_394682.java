if (jsonArray != null) {
    List<String> top250 = new ArrayList<String>();
    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject object = jsonArray.getJSONObject(i);
        String value = object.getString("content");
        top250.add(value);
    }
    listDataChild.put(listDataHeader.get(0), top250);
}