List<Key> keys = new ArrayList<Key>();
QueryResultIterator<Entity> iterator = result.iterator();
while (iterator.hasNext()) {
  keys.add(iterator.next().getKey());
}

datastore.delete(keys);