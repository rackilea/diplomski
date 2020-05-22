final Iterator<Entry<String,Integer>> iter = myLinkedHashMap.entrySet().iterator();
while(iter.hasNext()) {
  final Entry<String,Integer> entry = iter.next();
  if(entry.getKey().equals("something")) {
    iter.remove();
  }
}