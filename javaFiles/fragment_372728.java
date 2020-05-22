private Foo getKeyByValue(Map<Foo, List<Bar>> map, Bar bar){
    for (Map.Entry<Foo, List<Bar>> entry : map.entrySet()){
        if (entry.getValue().contains(bar)){
            return entry.getKey();
        }
    } 
  return null;
}