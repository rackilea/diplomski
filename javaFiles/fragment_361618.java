public V More ...remove(Object key) {
  if (session == null) {
   return null;
    }

synchronized (session) {
    entries = null;

   V value = get(key);
  session.removeAttribute(key.toString());

    return value;
 }
}