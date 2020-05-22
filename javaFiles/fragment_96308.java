public Map<String, IExchangeItem>  createAndInitialzeMap(int maxValue) {
    Map<String, IExchangeItem> map = new HashMap<>();
    String temp = "tempName";
    for(int i =0; i < maxValue ; i ++ ) {
            map.put(temp+i, new IExchangeItem());
    }   
    return map;
}