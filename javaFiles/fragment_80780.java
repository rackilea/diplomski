class AssertionException extends Exception {
  //content goes here
}

class Assert {
  public void sameSize( Collection<?> a, Collection<?> b ) {
    //TODO: handle null as well
    if( a.size() != b.size() ) {
      throw new AssertionException("some message"); 
    }
  }
}