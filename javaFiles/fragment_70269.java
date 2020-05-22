List<String> mData;
List<List<String>> tempList = new ArrayList<>();

for (int i = 0; i < contacts.length(); i++) {
    mData = new ArrayList<>();

    JSONObject c = contacts.getJSONObject(i);

    String id = c.getString("cat_id");
    String title = c.getString("cat_name");
    String image = c.getString("cat_img");

    mData.add(id);
    mData.add(title);
    mData.add(image);

    tempList.add(mData);
}