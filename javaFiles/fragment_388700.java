boolean found = false;
for (Map.Entry<String, String[]> entry : synonymMap.entrySet()) {
    String key = entry.getKey();
    String[] value = entry.getValue();
    if (key.equals(in) || Arrays.asList(value).contains(in)) {
        found = true;
        parseFile(key);
        System.out.println("Have a good day!");
        break;
    }
}
if (found) {
    break;
}