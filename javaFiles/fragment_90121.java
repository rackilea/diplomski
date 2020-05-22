if(hashmap.get(key) == null){
  value = new HashSet<Point2D.Double>();
}else{
  value = hashmap.get(key);
}
value.add(point_to_add);
hashmap.put(key,value);