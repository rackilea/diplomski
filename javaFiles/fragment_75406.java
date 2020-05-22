public int hashCode() {
   int h = 0;
   Iterator<Entry<K,V>> i = entrySet().iterator();
   while (i.hasNext())
       h += i.next().hashCode();
   return h;
}