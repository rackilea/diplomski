public static Map<String, Object> getStuffForIdentifierAsMap(String identifier) 
  throws IllegalAccessException {
    for (Stuff stuff : Stuff.values()) {
        if(stuff.getIdentifier().equals(identifier)) {
          ...
        }