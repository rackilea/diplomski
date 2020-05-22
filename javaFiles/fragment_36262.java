LinkedHashMap<String, String> map = ...
String startKey = "BA";
String endKey = "BM";

boolean isInRange = false;
for (Entry<String, String> entry : map.entrySet()) {
    String key = entry.getKey();
    if (!isInRange) {
        if (key.equals(startKey)) {
            isInRange = true;
        } else {
            continue;
        }
    }

    ...

    if (key.equals(endKey)) {
        break;
    }
}