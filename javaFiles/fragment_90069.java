Map<String, String[] > map . . . ;
if( map.containsKey(yourKey) ) {
   throw new IllegalArgumentException("Non-unique key! key = " + yourKey);
} else {
  map.put(yourKey,value);
}