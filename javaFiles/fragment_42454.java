private HashMap<String, List<String>> readFromSP(){
   SharedPreferences sharedPreferences = getSharedPreferences("HashMap", MODE_PRIVATE);
   String defValue = new Gson().toJson(new HashMap<String, List<String>>());
   String json=sharedPreferences.getString("map",defValue);
   TypeToken<HashMap<String,List<String>>> token = new TypeToken<HashMap<String,List<String>>>() {};
   HashMap<String,List<String>> retrievedMap=new Gson().fromJson(json,token.getType());
   return retrievedMap;
}