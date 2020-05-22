Iterator<Entry<String, Object>> it = session.entrySet().iteration;
while (it.hasNext) {
   Entry<String, Object> entry = it.next(); 
   if (condition) {
      it.remove(); // avoids a ConcurrentModificationException
   }
}