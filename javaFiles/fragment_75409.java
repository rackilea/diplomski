// getPage() remains unchanged
public Page getPage(Integer id) {
  Page p = cache.get(id);
  if (p == null) {
    synchronized (getCacheSyncObject(id)) {
      p = getFromDataBase(id);
      cache.store(p);
    }
  }
}

private int MAX_LOCKS = 100;
private Object[] locks = new Object[MAX_LOCKS];

{
    for(int i=0; i<locks.length; ++i)
        locks[i] = new Object();
}


private Object getCacheSyncObject(final Integer id) {  
  return locks[ id % MAX_LOCKS ];
}