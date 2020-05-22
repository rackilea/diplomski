public boolean hasChanged(String key, Object hash) {
    assert key != null && hash != null;

    Holder holder = hashCache.get(key); 
    if (holder == null) {
        synchronized (hashCache) { // Double-check that value hasn't been changed 
                                   // before entering synchronized block 
            holder = hashCache.get(key);
            if (holder == null) { 
                hashCache.put(key, new Holder(hash));
                return true; // first hash
            } // inner if
        }  // sync block
    } // outer if

    // No more else!

    synchronized (holder) {
        if (Objects.equals(holder.object, hash)) {
            return false; // hash not changed
        } else {
            holder.object = hash;
            return true; // hash changed
        }
    }
}