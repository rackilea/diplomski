...

  Map<Player, List<Attribute>> map = new HashMap<>();
  map.put(
    player("Lebron James"), 
    attribute("mid height", "mid weidght", "high vertical")
  );
}

private Player player(String name){
  return new Player(name);
}

private List<Attribute> attribute(String... strAttributes){
  List<Attribute> resultList = new ArrayList<>();
  for(String strAttr : strAttributes){
    resultList.add(new Attribute(strAttr));
  }
  return resultList;
}