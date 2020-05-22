JsonArray askbid = new BinanceApi().allBookTickers();

 for (JsonElement obj : askbid)
 {
         JsonObject jobj = obj.getAsJsonObject();
         String symbol = jobj.get("symbol").toString();
         String bidPrice = jobj.get("bidPrice").toString();
         String bidQty = jobj.get("bidQty").toString();
         String askPrice = jobj.get("askPrice").toString();
         String askQty = jobj.get("askQty").toString();
 }