JSONObject jsonObject = new JSONObject("{names:['1','2','3']}");
JSONArray jsonArray = jsonObject.getJSONArray("names");

List<String> names = new ArrayList<String>();
for(int i = 0; i < jsonArray.length(); i++){
     names.add(jsonArray.getString(i));
}
System.out.println(names);