/**
  * Save the state of the <tt>HashMap</tt> instance to a stream (i.e.,
  * serialize it)
  *
  * @serialData The <i>capacity</i> of the HashMap (the length of the
  *             bucket array) is emitted (int), followed by the
  *             <i>size</i> (an int, the number of key-value
  *             mappings), followed by the key (Object) and value (Object)
  *             for each key-value mapping.  The key-value mappings are
  *             emitted in no particular order.
  */
      private void writeObject(java.io.ObjectOutputStream s)
             throws IOException
         {
             Iterator<Map.Entry<K,V>> i =
                 (size > 0) ? entrySet0().iterator() : null;

            // Write out the threshold, loadfactor, and any hidden stuff
            s.defaultWriteObject();

            // Write out number of buckets
            s.writeInt(table.length);

            // Write out size (number of Mappings)
            s.writeInt(size);

            // Write out keys and values (alternating)
            if (i != null) {
                while (i.hasNext()) {
                    Map.Entry<K,V> e = i.next();
                    s.writeObject(e.getKey());
                    s.writeObject(e.getValue());
                }
            }
        }