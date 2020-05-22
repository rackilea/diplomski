private static final ConcurrentMap<String, Buffered> imageMap = 
    new MapMaker().softValues().makeMap();

public static Buffered addImage(String sum, final byte[] imageData) {
  Buffered buffered = new Buffered(imageData, sum);
  Buffered inMap = imageMap.putIfAbsent(sum, buffered);
  return inMap != null ? inMap : buffered;
}

public static Buffered getImage(String sum) {           
  return imageMap.get(sum);
}