for ( String s : new Iterable { 
  public iterator<String> () {
    return set.iterator ();
  }
} ) {
}