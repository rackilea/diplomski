public String convertToDatabaseValue() {
    return Arrays.stream(Feature.values()).map(f -> isFeatureEnabled(f) ? "1" : "0").collect(joining());
}

public Map<Feature, Boolean> initFromDatabaseValue(String bitString) {
    // Note that, bitString length should equals to your number of feature. Or you have to padding it
    char[] bitArray = bitString.toCharArray();
    return Arrays.stream(Feature.values())
            .collect(toMap(f -> f,
                    f -> bitArray[f.getIndex()] == '1',
                    (v1, v2) -> v2,
                    LinkedHashMap::new));
}