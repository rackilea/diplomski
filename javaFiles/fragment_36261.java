NavigableMap<String, String> map = new TreeMap<>(...);
String startKey = "BA";
String endKey = "BM";

Map<String, String> subMap = map.subMap(startKey, endKey);
for (Entry<String, String> entry : subMap.entrySet()) {
    ...
}