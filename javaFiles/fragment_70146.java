JSONArray arr = new JSONArray(yourJSONresponse);
String[] item_id=new String[array.length()];
String[] Head_item_id=new String[arr .length()];
for(int i = 0; i < arr.length(); i++){
    item_id[i]=arr.getJSONObject(i).getString("item_id");
    Head_item_id[i]=arr.getJSONObject(i).getString("Head_item_id");
}