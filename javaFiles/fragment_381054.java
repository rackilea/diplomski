Properties props = ...; // load your file
List<String> keysToRetrieve = Arrays.asList("sourceAttrStart", "user", ..., "sourceAttrEnd");

Map<String, String> entriesToRetrieve = new HashMap<>();
for (String key : keysToRetrieve){
   entriesToRetrieve.put(key, props.getProperty(key)); 
}