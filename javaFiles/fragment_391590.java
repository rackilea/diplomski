private boolean hasCached;
private T cached;

public boolean hasNext() {
   if ( hasCached ) return true;
   //iterate until you find one and set hasCached and cached
}

public T next() {
   if ( hasCached ) {
      hasCached = false;
      return cached;
   }
   //iterate until next matches
}