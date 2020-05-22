public <T extends Comparable<T>> boolean compare(List<T> list, T other) {
  for( T object : list ) {
    if( object.compareTo( other ) == 0 ) {
      return true;
    }
  }    
  return false;
}

compare( new ArrayList<String>(), "foo"); //compiles, since String implements Comparable<String>
compare( new ArrayList<Object>(), null); //doesn't compile, since Object doesn't implement Comparable<Object>