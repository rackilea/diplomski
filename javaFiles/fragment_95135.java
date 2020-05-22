while(iterator.hasNext()) {
    String key = iterator.next().toString();
    Object value = dbo.get(key);
    if (value instanceof ArrayList){
        ArrayList<?> dboArrayNested = (ArrayList<?>) value;
        for (Object dboNestedObj : dboArrayNested) {
            if (dboNestedObj instanceof Document) {
                printKeysNested(Document.class.cast(dboNestedObj));
            }
        }
    // else if extra...
    } else if (value instanceof Document) {
        printKeysNested(Document.class.cast(value));
    }
}

public static void printKeysNested(Document dboNested) {
    Set<String> keysNested = dboNested.keySet();
    System.out.println("KeyNested: " + keysNested);
}