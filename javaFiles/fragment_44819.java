Iterator<Object> iterator = fo_ArrayList.iterator();
while(iterator.hasNext()) {
  if(iterator.next().hasHitGround()) {
    iterator.remove();
  }
}