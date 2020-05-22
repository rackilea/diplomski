boolean alleq = true;
Set<String> key1 = new HashSet<>( map1.keySet() );
key1.retainAll( map2.keySet();
for( String s: key1 ) ){
     if( ! map1.get(s).equals( map2.get(s) ) ){
          alleq = false;
          break;
     }
}