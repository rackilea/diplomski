synchronized (entityList) {
  // Readers might do:
  itr = entityList.iterator();
  while (i.hasNext())
    ... do stuff ...
}