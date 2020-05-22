CacheValue v = map.get(k);
sychronized(v) {
  if(v.isRemoved()) {
    // object removed, handle...
  }
}