// inversed the map using "google-guava.jar"
Multimap<Long, String> inverseMap = HashMultimap.create();
for (Entry<String, Long> entry : countMap .entrySet()) {
    inverseMap.put(entry.getValue(), entry.getKey());
}

for (Entry<Long, Collection<String>> entry : inverseMap.asMap().entrySet()) {
    // split the values into an array
    Object[] split = entry.getValue().stream().toArray(); 
    if (split != null && split.length > 1) { 
        for (int j = 0; j < split.length; j++) {
            System.out.println(String.valueOf(split[j]) + " : " 
                             + countMap.get(String.valueOf(split[j])));
        }
    }
}