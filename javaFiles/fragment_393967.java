ArrayList<String[]> myArr = new ArrayList<String[]>();
for (int i=0; i < myJSONArray.length(); i++) {
    JSONObject j = myJSONArray.getJSONObject(i);
    String[] t = {j.getString("que"),j.getString("ans")};
    myArr.add[t];
}