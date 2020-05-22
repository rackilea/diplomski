for (String token: tokens) {
  if(!map.containsKey(token)){
      map.put(token,0);
  }
  map.put(token,map.get(token)+1);
}