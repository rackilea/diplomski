Set<Map.Entry<String, Integer>> elements = dupeMap.entrySet();
Iterator<Map.Entry<String, Integer>> iterator = elements.iterator();
while(iterator.hasNext()) {
   Map.Entry<String, Integer> element = iterator.next();
   if(element.getValue() ==1) {
       iterator.remove();
    }
}
System.out.printf("Duplicatesss: %s\n",elements);