private void checkDupeKeys(SortedMap<String, Fizz> fizzes, 
    SortedMap<String, Buzz> buzzes, 
    SortedMap<String, Foobar> foobars) {

    // copies the key set
    Set<String> fizBuzSet = new HashSet<>(fizzes.keySet());

    // this removes all elements of the set that aren't present in the given key set
    fizBuzSet.retainAll(buzzes.keySet());

    // aggregating dupes if needed
    Map<String, Collection<String>> dupes = new HashMap<>();
    // flag to throw exception if needed
    boolean areThereDupes = false;

    if (!fizBuzSet.isEmpty()) {
        areThereDupes = true;
        // TODO log fizBuzSet as set of duplicates between fizzes and buzzes
        // or...
        dupes.put("Fizzes vs Buzzes", fizBuzSet);
    }
    // TODO repeat with fizzes vs foobars, then again with buzzes vs foobars

    // you can either log the dupes separately, or use a Map<String,Collection<String>> where the  
    // keys represent a compound of the two SortedMaps being compared and the values represent the actual duplicates  
    // e.g...
    if (areThereDupes) {
        // TODO throw exception with dupes map representation in message
    }

}