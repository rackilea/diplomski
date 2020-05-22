JSONArray Result= json.getJSONObject("ResultSet").getJSONArray("Result");
for(int i = 0; i<Result.length(); i++){ 
    String symbol = Result.getJSONObject(i).getString("Symbol");
    if(!symbol.contains("_"))
          return symbol;
}