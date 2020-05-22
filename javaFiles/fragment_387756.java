void setup(){
  JSONArray data = loadJSONArray("https://btc-e.com/api/2/btc_usd/trades");//load the data

  for (int i = 0; i < data.size(); i++) {//traverse the data

    JSONObject entry = data.getJSONObject(i); //get each entry in the list/array
    //parse the values
    float amount = entry.getFloat("amount");
    int price    = entry.getInt("price");
    String item  = entry.getString("item");
    String pc    = entry.getString("price_currency");
    int tid      = entry.getInt("tid");
    int date     = entry.getInt("date");
    String tt    = entry.getString("trade_type");

    //do something with the data
    float x = (float)i/data.size() * width;
    float y = 100 - (amount * 20);
    line(x,height,x,y);
  }
}