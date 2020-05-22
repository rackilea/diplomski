for(Map<Long,Set<String>> entry  : map.entrySet()){

   for(String s : entry.getValue()){
    System.out.println(entry.getKey() + " : " + s);
   }
}