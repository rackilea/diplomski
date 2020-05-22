Set<String> keys = myMap.keySet();
StringBuilder sb = new StringBuilder("Characters: ");
int i = 0;
for (String key : keys) {
    if (i == 0) {
        sb.append(key);
        i++;
    } else {
        sb.append(", ");
        sb.append(key);
    }
 }
 String consolidatedKey = sb.toString();