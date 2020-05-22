Map<String, ExchangeSummaryItem> result = new HashMap<>();

//Map.entrySet() gives you access to both key and value.
for (Map.Entry<String,ExchangeSummaryItem> item : under20.entrySet()) {
     int ObjSellAverage = item.getValue().getSellAverage();
     int ObjSellQ = item.getValue().getSellQuantity();
     int ObjBuyQ = item.getValue().getBuyQuantity();

     if (!(ObjSellAverage > 20000 && ObjSellQ == 0 && ObjBuyQ == 0)){
          result.put(item.getKey(), item.getValue());
     }
}