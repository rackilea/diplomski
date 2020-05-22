Set<String> theSet = myMap.get(aKey);
if (theSet == null) {
    theSet = new HashSet<String>();
    myMap.put(aKey, theSet);
}
theSet.add(value);