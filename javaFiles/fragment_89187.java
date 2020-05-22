Set<String> seenStrings = Collections.newSetFromMap(new ConcurrentHashMap<>());
for (String aString : stringList) {
    if (seenStrings.add(aString)) {               
            // Not seen yet
    }
}