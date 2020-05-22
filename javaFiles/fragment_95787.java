public V put(Object key, Object value) {
    V oldValue = get(key);
    while (!tryPut(key, value)) {
        rehash();
    }
    return oldValue;
}

private void rehash() {
    increaseCapacity();

    boolean success;
    do {
       success = true;
       reallocateSpace();

       for (each old key/value pair) {
          if (!tryPut(key, value)) {
             success = false;
             break;
          }
       }
    } while (!success);
}

private boolean tryPut(Object key, Object value) {
   // Try adding the key/value pair using a
   // hashtable specific implementation, returning
   // true if it works and false otherwise.
}