Iterator<Object> iter = objects.iterator();
Object obj;
while (iter.hasNext()) {
    obj = iter.next();
    if (obj instanceof ObjectA) {
        // ... do stuff ...
    }
}