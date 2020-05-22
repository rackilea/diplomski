Object o = map.get(k);
synchronized(o) {
  if(map.get(k) != o) {
    // object removed, handle...
  }
}