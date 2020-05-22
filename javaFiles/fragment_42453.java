private void insertToSP(HashMap<String, List<String>> jsonMap) {
  String jsonString = new Gson().toJson(jsonMap);
  SharedPreferences sharedPreferences = getSharedPreferences("HashMap", MODE_PRIVATE);
  SharedPreferences.Editor editor = sharedPreferences.edit();
  editor.putString("map", jsonString);
  editor.apply();
}