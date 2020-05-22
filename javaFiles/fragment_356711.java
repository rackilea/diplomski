for(Entry<String, Object> entry : session.entrySet()) {
   if (condition) {
      // throws a ConcurrentModificationException
      session.remove(entry.getKey());
   }
}