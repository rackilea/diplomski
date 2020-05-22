static {
  Map<String, Class<? extends Flower>> map = new HashMap<String, Class<? extends Flower>>();
  map.put(Rose.NAME, Rose.class);
  // add all flowers
  FLOWERS = Collections.unmodifieableMap(map);
}