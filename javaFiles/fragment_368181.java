ArrayList<String> myEmailArray = new ArrayList<>();

JSONObject  jsonObj = new JSONObject(yourJson);
JSONArray jsonEmailArray = jsonObj.getJSONArray("emails");
for(int i=0; i<=jsonEmailArray.length(); i++){
     myEmailArray.add(jsonEmailArray.getString(i));
}