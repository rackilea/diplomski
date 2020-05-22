// Write out any hidden serialization magic
s.defaultWriteObject();

// Write out size
s.writeInt(size);

// Write out all elements in the proper order.
for (Entry e = header.next; e != header; e = e.next)
    s.writeObject(e.element);