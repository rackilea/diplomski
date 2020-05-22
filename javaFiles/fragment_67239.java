Map<String, String> testMap = ... // setup testMap

Map<String, String> result = new HashMap<>();
for (final Entry<String, String> entry : testMap.entrySet()) {
    result.put(
        entry.getKey(), 
        findCorrespondingValue(testMap, entry.getValue())
    );
}